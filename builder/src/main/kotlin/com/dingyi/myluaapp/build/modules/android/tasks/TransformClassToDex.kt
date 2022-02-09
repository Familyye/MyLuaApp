package com.dingyi.myluaapp.build.modules.android.tasks

import com.android.tools.r8.CompilationMode
import com.android.tools.r8.D8
import com.android.tools.r8.D8Command
import com.android.tools.r8.OutputMode
import com.dingyi.myluaapp.build.api.Module
import com.dingyi.myluaapp.build.api.Task
import com.dingyi.myluaapp.build.default.DefaultTask
import com.dingyi.myluaapp.build.dependency.ProjectDependency
import com.dingyi.myluaapp.build.modules.android.config.BuildConfig
import com.dingyi.myluaapp.common.kts.Paths
import com.dingyi.myluaapp.common.kts.endsWith
import com.dingyi.myluaapp.common.kts.println
import com.dingyi.myluaapp.common.kts.toMD5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.luaj.vm2.LuaNumber
import java.io.File
import java.nio.file.Path
import java.util.*

class TransformClassToDex(private val module: Module) : DefaultTask(module) {

    private val classCompileDirectory: String
        get() = "build/intermediates/javac/$buildVariants/classes"

    override val name: String
        get() = getType()

    private lateinit var buildVariants: String

    private fun getType(): String {
        if (this::buildVariants.isInitialized) {
            return "Transform${
                buildVariants.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }ClassToDex"
        }
        return javaClass.simpleName
    }

    private val transformDexFiles = mutableListOf<File>()


    private val outputDirectory: String
        get() = "build/intermediates/dex_archive/$buildVariants"


    override suspend fun prepare(): Task.State {

        buildVariants = module.getCache().getCache<BuildConfig>("${module.name}_build_config")
            .buildVariants


        val allTransformDexFiles =
            module.getFileManager()
                .resolveFile(classCompileDirectory, module)
                .walkBottomUp()
                .filter { it.isFile && it.name.endsWith("class") }
                .toList()

        if (allTransformDexFiles.isEmpty()) {
            return Task.State.`NO-SOURCE`
        }

        val incrementalTransformDexFiles =
            allTransformDexFiles.filterNot {
                module.getFileManager()
                    .equalsSnapshot(it) and module
                    .getFileManager()
                    .equalsSnapshot(getClassTransformDexPath(it))
            }



        transformDexFiles.addAll(incrementalTransformDexFiles)

        return when {
            incrementalTransformDexFiles.isEmpty() -> Task.State.`UP-TO-DATE`
            incrementalTransformDexFiles.size < allTransformDexFiles.size -> Task.State.INCREMENT
            incrementalTransformDexFiles.size == allTransformDexFiles.size -> Task.State.DEFAULT
            else -> Task.State.DEFAULT
        }

    }

    private fun getLibraryFiles(): List<Path> {
        return module
            .getDependencies()
            .flatMap {
                it.getDependenciesFile()
            }.flatMap { file ->
                if (file.name.endsWith("aar")) {
                    val extractFile = File(
                        "${Paths.extractAarDir}${File.separator}${
                            file.path.toMD5()
                        }"
                    )
                    extractFile.walkBottomUp()
                        .filter {
                            it.isFile && it.name.endsWith("jar")
                        }
                        .toList()
                } else {
                    listOf(file)
                }
            }.filter {
                it.name.endsWith("jar") && it.exists()
            }.toMutableList()
            .map { it.toPath() }
    }

    override suspend fun run(): Unit = withContext(Dispatchers.IO) {

        val command = D8Command
            .builder()
            .addClasspathFiles(getLibraryFiles())
            .addLibraryFiles(
                File(Paths.buildPath, "jar/core-lambda-stubs.jar").toPath(),
                File(Paths.buildPath, "jar/android.jar").toPath()
            )
            .addProgramFiles(transformDexFiles.map { it.toPath() })
            .setIntermediate(true)
            .setMinApiLevel(getMinSdk())
            .setMode(if (buildVariants == "debug") CompilationMode.DEBUG else CompilationMode.RELEASE)
            .setOutput(
                module.getFileManager()
                    .resolveFile(outputDirectory, module)
                    .apply {
                        mkdirs()
                    }
                    .toPath(), OutputMode.DexFilePerClassFile
            )
            .build()

        D8.run(command)

        module.getFileManager()
            .resolveFile(outputDirectory, module)
            .walkBottomUp()
            .filter { it.isFile }
            .forEach {
                module
                    .getFileManager()
                    .snapshot(it)
            }

        module.getFileManager()
            .resolveFile(classCompileDirectory, module)
            .walkBottomUp()
            .filter { it.isFile }
            .forEach {
                module
                    .getFileManager()
                    .snapshot(it)
            }

    }

    private fun getMinSdk():Int {
        val minSdkString = module
            .getMainBuilderScript()
            .get("android.defaultConfig.minSdkVersion")

        if (minSdkString is LuaNumber) {
            return minSdkString.toint()
        }

        return 21
    }

    private fun getClassTransformDexPath(classPath: File): File {
        val inputDirectory = module
            .getFileManager()
            .resolveFile(classCompileDirectory, module)

        return File(
            module
                .getFileManager()
                .resolveFile(outputDirectory, module),
            classPath.path.substring(inputDirectory.path.length + 1)
        )

    }


}