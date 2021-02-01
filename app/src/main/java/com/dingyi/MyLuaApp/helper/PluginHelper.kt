package com.dingyi.MyLuaApp.helper

import android.content.Intent
import android.net.Uri
import com.androlua.LuaActivity
import com.dingyi.MyLuaApp.activitys.EditorActivity
import com.dingyi.MyLuaApp.base.BaseActivity
import com.dingyi.MyLuaApp.base.BaseViewManager
import com.dingyi.MyLuaApp.manager.activity.EditorViewManager
import com.dingyi.MyLuaApp.utils.forEachDir
import com.dingyi.luaj.LuaJ
import org.luaj.vm2.LuaTable
import org.luaj.vm2.LuaValue

class PluginHelper(val activity: BaseActivity<*>) {




    private val luaJ = LuaJ();

    private val pluginList = mutableListOf<LuaTable>()

    init {
        forEachDir(activity.assetDir+"/plugin") { file ->
            val table = luaJ.loadFile(file.path + "/init.lua")

            table.set("path", LuaValue.valueOf(file.path))
            pluginList.add(table)
        }
    }

    fun getPluginType(luaTable: LuaTable): Type {
        return when (luaTable["pluginType"].tojstring()) {
            "Editor" -> Type.Editor
            else -> Type.Activity
        }
    }

    fun runPlugin(packageName: String, any: Array<Any>) {
        pluginList.forEach {

            if (it["pluginId"].tojstring() == packageName) {
                if (getPluginType(it) == Type.Activity) {
                    val intent = Intent(activity, LuaActivity::class.java)
                    intent.putExtra("name",it["path"].tojstring()+"/main.lua")
                    intent.data=Uri.parse("file://"+it["path"].tojstring()+"/main.lua")
                    intent.putExtra("arg", any)
                    activity.startActivityForResult(intent,0)
                }
            }
        }
    }

    enum class Type {
        Editor, Activity
    }

}