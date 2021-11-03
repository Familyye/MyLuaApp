package com.dingyi.myluaapp.core.project

import com.dingyi.myluaapp.common.kts.toFile
import org.luaj.vm2.LuaTable
import org.luaj.vm2.LuaValue
import java.io.File
import java.io.FileNotFoundException
import java.io.OutputStream

/**
 * @author: dingyi
 * @date: 2021/10/12 20:10
 * @description: project bean class
 **/
class Project(
    val projectPath: String = "",
    val projectManager: ProjectManager
) : IProject {


    data class AppProject(
        val appPackageName: String,
        val appName: String,
        val iconPath: String,
        val path: String
    )


    override fun delete(): Boolean {
        return true;
    }

    override fun deleteFile(path: String) {
        ProjectFile(path,this).deleteFile()
    }

    fun generateAppProject(): AppProject? {
        return runCatching {
            val table = projectManager.globalLuaJVM.loadFile("$projectPath/.MyLuaApp/.config.lua")
            AppProject(
                appName = table["appName"].tojstring(),
                appPackageName = table["appPackageName"].tojstring(),
                iconPath = projectPath + "/" + table["iconPath"].tojstring(),
                path = projectPath
            )
        }.onFailure {
            it.printStackTrace()
        }
            .getOrNull()
    }

    override fun openFile(path:String): ProjectFile {
        if (!path.toFile().exists()) {
            throw FileNotFoundException("Not Found File.")
        }
        val file=getOpenedFile()
        val table = projectManager.globalLuaJVM.loadFile(file.absolutePath)
        table.insert(table.keyCount()+1, LuaValue.valueOf(path))
        file.writeText(formatOpenFile(table))
        return ProjectFile(path,this)
    }

    private fun formatOpenFile(table: LuaTable):String {
        val buffer = StringBuilder()
        buffer.append("openFiles={").append("\n")
        for (i in 1..table.keyCount()) {
            val key= table[i]
            val value = table[key].tojstring()
            buffer.append('[').append(key)
                .append(']').append(" = ")
                .append('"').append(value)
                .append(",").append("\n")
        }
        buffer.removeRange(buffer.lastIndex-2..buffer.lastIndex)
        buffer.append("\n").append("}")
        return buffer.toString()
    }

    private fun getOpenedFile(): File {
        val path="$projectPath/.MyLuaApp/open_files.lua"
        val file=path.toFile()
        if (!file.exists()) {
            file.writeText("""
                openFiles = {}
            """.trimIndent())
        }
        return file
    }

    override fun getOpenFiles(): List<ProjectFile> {
        val table = projectManager.globalLuaJVM.loadFile(getOpenedFile().absolutePath)
        val result = mutableListOf<ProjectFile>()
        table.keys().forEach {
            val project = table.get(it).tojstring()
            result.add(ProjectFile(project,this))
        }
        return result
    }

    override fun saveAllOpenFile(): Boolean {
        TODO("Not yet implemented")
    }

    override fun backup(exportOutputStream: OutputStream): Boolean {
        return true;
    }

    fun getChangeProjectFiles() {

    }


}