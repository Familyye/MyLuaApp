package com.dingyi.myluaapp.plugin.runtime.plugin

import android.content.Context

import com.dingyi.myluaapp.MainApplication
import com.dingyi.myluaapp.plugin.api.Plugin
import com.dingyi.myluaapp.plugin.api.PluginModule
import com.dingyi.myluaapp.plugin.api.action.ActionService
import com.dingyi.myluaapp.plugin.api.build.BuildService
import com.dingyi.myluaapp.plugin.api.editor.EditorService


import com.dingyi.myluaapp.plugin.runtime.project.ProjectService

object PluginModule: PluginModule {


    private var pluginManager: PluginManager? = PluginManager(this)

    private val defaultProjectService = ProjectService(this)


    override fun init() {
        pluginManager?.init()
    }

    override fun loadPlugin(pluginId: String) {
        pluginManager?.loadPlugin(pluginId)
    }

    override fun loadAllPlugin() {
        pluginManager?.loadAllPlugin()
    }

    override fun installPlugin(pluginPath: String) {
        pluginManager?.installPlugin(pluginPath)
    }

    override fun uninstallPlugin(pluginId: String) {
        pluginManager?.uninstallPlugin(pluginId)
    }

    override fun getAllPlugin(): List<Plugin> {
        return pluginManager?.getAllPlugin() ?: listOf()
    }

    override fun stop() {

        pluginManager?.stop()
        pluginManager = null
    }

    override fun getProjectService(): ProjectService {
        return defaultProjectService
    }

    override fun getEditorService(): EditorService {
        TODO("Not yet implemented")
    }

    override fun getActionService(): ActionService {
        TODO("Not yet implemented")
    }

    override fun getBuildService(): BuildService {
        TODO("Not yet implemented")
    }

    override fun getResourceManager(plugin: Plugin) {
        TODO("Not yet implemented")
    }

    override fun getProperties() {
        TODO("Not yet implemented")
    }


    override fun getAndroidContext(): Context {
        return MainApplication.instance
    }
}