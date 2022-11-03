package com.dingyi.myluaapp

import android.app.Application
import android.content.Context


import kotlin.properties.Delegates
import com.hjq.language.MultiLanguages
import com.tencent.mmkv.MMKV
import io.github.dingyi.androlua.vm.LuaGlobal


/**
 * @author: dingyi
 * @date: 2021/8/4 13:02
 * @description:
 **/
class MainApplication : Application() {


    override fun onCreate() {

        super.onCreate()

        instance = this


        // 初始化语种切换框架
        MultiLanguages.init(this);

        CrashHandler.init(this)

        MMKV.initialize(this)

        LuaGlobal.init(this)


        //set android application

        val ideApplicationManager = classLoader
            .loadClass("com.dingyi.myluaapp.openapi.application.ApplicationManager")

        val setAndroidApplicationMethod = ideApplicationManager
            .getMethod("setAndroidApplication", Application::class.java)

        setAndroidApplicationMethod.invoke(null, this)
    }

    override fun attachBaseContext(base: Context) {
        // 绑定语种
        super.attachBaseContext(MultiLanguages.attach(base))
    }

    companion object {
        var instance by Delegates.notNull<MainApplication>()
    }

}