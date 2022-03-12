package com.dingyi.myluaapp.plugin.modules.lua.build

import com.dingyi.myluaapp.build.api.Module
import com.dingyi.myluaapp.build.api.Project
import com.dingyi.myluaapp.build.api.builder.Builder
import com.dingyi.myluaapp.build.api.service.HookService
import com.dingyi.myluaapp.build.modules.android.module.AndroidModule
import org.luaj.vm2.LuaTable

class LuaBuildService:HookService {
    override fun onCreateModule(module: Module): Module {
        val plugins = module.getMainBuilderScript()
                .get("plugins")

        if (plugins is LuaTable) {
            for (key in plugins.keys()) {
                val value = plugins[key].tojstring()
                if (value == "com.androlua") {
                    return injectModule(module)
                }
            }
        }
        return module
    }

    private fun injectModule(module: Module): Module {
        TODO()
    }

    override fun onCreateProject(project: Project): Project {
        return project
    }

    override fun onCreateBuilder(builder: Builder): Builder {
       return builder
    }
}