package com.dingyi.myluaapp.plugin.modules.android

import com.dingyi.myluaapp.common.kts.getJavaClass
import com.dingyi.myluaapp.plugin.api.Plugin
import com.dingyi.myluaapp.plugin.api.context.PluginContext
import com.dingyi.myluaapp.plugin.modules.android.action.ProjectMenuAction
import com.dingyi.myluaapp.plugin.modules.android.project.AndroidProjectCreatorProvider
import com.dingyi.myluaapp.plugin.modules.android.project.AndroidProjectProvider
import com.dingyi.myluaapp.plugin.modules.default.action.DefaultActionKey

class MainPlugin: Plugin {

    override fun onInstall(context: PluginContext) {

    }

    override fun onUninstall(context: PluginContext) {

    }

    override fun onStart(context: PluginContext) {

        context
            .getProjectService().apply {
                addProjectCreatorProvider(AndroidProjectCreatorProvider())
                addProjectProvider(AndroidProjectProvider())
            }


        context.getActionService()
            .apply {
                registerAction(
                    getJavaClass<ProjectMenuAction>(),
                    DefaultActionKey.ADD_PROJECT_MENU
                )
            }


    }

    override fun onStop(context: PluginContext) {

    }

    override val pluginId: String
        get() = "com.dingyi.MyLuaApp.core.plugin.android"
    override val pluginName: String
        get() = "Android项目模块"
    override val pluginVersion: String
        get() = "1.0"
    override val pluginAuthor: String
        get() = "dingyi"
    override val pluginDescription: String
        get() = "提供对Android项目支持的插件"

}