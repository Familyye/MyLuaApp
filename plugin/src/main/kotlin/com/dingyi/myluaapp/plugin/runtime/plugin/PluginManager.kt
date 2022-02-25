package com.dingyi.myluaapp.plugin.runtime.plugin

import com.dingyi.myluaapp.common.kts.Paths
import com.dingyi.myluaapp.common.kts.getJavaClass
import com.dingyi.myluaapp.plugin.api.Plugin
import com.dingyi.myluaapp.plugin.api.context.PluginContext
import com.google.gson.Gson
import java.io.File

class PluginManager(private val context: PluginContext) {


    private val allPlugin = mutableListOf<Plugin>()

    private val loadPlugin = mutableListOf<Plugin>()

    private val allPluginPath = mutableMapOf<String, String>()

    fun getAllPlugin() = allPlugin

    fun init() {

        val pluginConfigPath = File(Paths.pluginDir, "plugin.json")

        val configList = Gson()
            .fromJson(
                pluginConfigPath.readText(),
                getJavaClass<List<Map<String, String>>>()
            )

        configList.forEach {
            val pluginClass = it["pluginMainClass"]
            val pluginPath = it["pluginPath"]

            if (pluginClass == null) {
                error("Missing plugin class")
            }


            if (pluginPath == "null") {
                val plugin = Class.forName(pluginClass).newInstance()


                if (plugin is Plugin) {
                    allPluginPath[plugin.pluginId] = pluginPath.toString()

                    allPlugin.add(plugin)
                } else {
                    error("Load PluginClass $pluginClass fail.The Class isn't extends Plugin")
                }

            }
        }

    }

    fun loadPlugin(pluginId: String) {
        allPlugin.find { it.pluginId == pluginId }
            ?.let { preLoadPlugin -> if (loadPlugin.find { it.pluginId == preLoadPlugin.pluginId } == null) preLoadPlugin else null }
            ?.apply {
                loadPlugin.add(this)
            }
            ?.onStart(context)
    }

    fun loadAllPlugin() {
        allPlugin.forEach { preloadPlugin ->
            if (loadPlugin.find { it.pluginId == preloadPlugin.pluginId } == null) {
                preloadPlugin.onStart(context)
            }
        }
        loadPlugin.addAll(allPlugin)
    }

    fun uninstallPlugin(pluginId: String) {

    }

    fun installPlugin(pluginPath: String) {


    }

    fun stop() {
        loadPlugin.forEach {
            allPluginPath.remove(it.pluginId)
            it.onStop(context)
        }
    }

    fun getPluginPath(plugin: Plugin): Any {
        TODO("Not yet implemented")
    }
}