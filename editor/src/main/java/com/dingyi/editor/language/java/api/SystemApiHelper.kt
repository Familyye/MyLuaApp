package com.dingyi.editor.language.java.api

import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import com.androlua.LuaActivity
import com.androlua.LuaApplication
import com.dingyi.lua.analyze.info.Type
import java.lang.reflect.AccessibleObject
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.util.*


/**
 * @author: dingyi
 * @date: 2021/8/20 23:15
 * @description:
 **/
object SystemApiHelper {



    fun findClass(className: String): Boolean {
        return runCatching {
            LuaApplication.getInstance().classLoader.loadClass(className)
        }.isSuccess
    }

    private fun findPublicStaticField(clazz: Class<*>, name: String): List<Field> {
        return mutableListOf<Field>().apply {
            clazz
                .fields
                .filter {
                    Modifier.isStatic(it.modifiers)
                }
                .filter {
                    it.name.lowercase(Locale.getDefault())
                        .startsWith(name.lowercase(Locale.getDefault()))
                }
                .forEach {
                    add(it)
                }
        }
    }

    private fun findPublicStaticMethod(clazz: Class<*>, name: String): List<Method> {
        return mutableListOf<Method>().apply {
            clazz
                .methods
                .filter {
                    Modifier.isStatic(it.modifiers)
                }
                .filter {
                    it.name.lowercase(Locale.getDefault())
                        .startsWith(name.lowercase(Locale.getDefault()))
                }
                .forEach {
                    add(it)
                }
        }
    }

    private fun findPublicMethod(clazz: Class<*>, name: String): List<Method> {
        return mutableListOf<Method>().apply {
            clazz
                .methods
                .filterNot {
                    Modifier.isStrict(it.modifiers)
                }
                .filter {
                    it.name.lowercase(Locale.getDefault())
                        .startsWith(name.lowercase(Locale.getDefault()))
                }
                .forEach {
                    add(it)
                }
        }
    }

    private fun findPublicField(clazz: Class<*>, name: String): List<Field> {
        return mutableListOf<Field>().apply {
            clazz
                .fields
                .filterNot {
                    Modifier.isStrict(it.modifiers)
                }
                .filter {
                    it.name.lowercase(Locale.getDefault())
                        .startsWith(name.lowercase(Locale.getDefault()))
                }
                .forEach {
                    add(it)
                }
        }
    }

    private fun getPublicStaticField(clazz: Class<*>, name: String): Class<*>? {
        return runCatching {
            clazz.getField(name)
        }.getOrNull()?.run {
            if (Modifier.isStatic(this.modifiers)) {
                println("type:${this.type}")
                return this.type
            }
            return null
        }
    }

    private fun getPublicStaticMethod(clazz: Class<*>, name: String): Class<*>? {
        return runCatching {
            clazz.getMethod(name)
        }.getOrNull()?.run {
            if (Modifier.isStatic(this.modifiers)) {
                return this.returnType
            }
            return null
        }
    }

    private fun getPublicField(clazz: Class<*>, name: String): Class<*>? {
        return runCatching {
            clazz.getField(name)
        }.getOrNull()?.run {
            return this.type
        }
    }

    private fun getPublicMethod(clazz: Class<*>, name: String): Class<*>? {
        return runCatching {
            clazz.getMethod(name)
        }.getOrNull()?.run {
            return this.returnType
        }
    }

    fun getPublicStaticFieldData(clazz: Class<*>, name: String): List<FieldData> {
        return findPublicStaticMethod(clazz, name)
            .map {
                FieldData(Type.METHOD, it.name, it.returnType, it)
            }
            .plus(
                findPublicStaticField(clazz, name).map {
                    FieldData(Type.FIELD, it.name, it.type, it)
                }
            )
    }

    fun getPublicFieldData(clazz: Class<*>, name: String): List<FieldData> {
        return findPublicMethod(clazz, name)
            .map {
                FieldData(Type.METHOD, it.name, it.returnType, it)
            }
            .plus(
                findPublicField(clazz, name).map {
                    FieldData(Type.FIELD, it.name, it.type, it)
                }
            ).plus(getPublicStaticFieldData(clazz, name))
    }

    data class ClassData(
        var classList: List<Class<*>>,
        val name: String,
        var isNewInstance: Boolean = false,
    )

    data class FieldData(
        val type: Type,
        val name: String = "",
        val typeClass: Class<*>?,
        val base: AccessibleObject
    )

    fun analyzeCode(code: String): ClassData {

        var data = ClassData(listOf(), code)
        code.split('.').forEach {
            data = analyzeCode(it, data)
        }
        return data
    }

    private fun analyzeCode(
        code_: String,
        last: ClassData
    ): ClassData {
        val lastClassList = last.classList
        val resultList = mutableListOf<Class<*>>()
        var code = code_

        if (code.indexOf("(") != -1) {
            last.isNewInstance = true
            code = code.substring(0, code.indexOf('('))
        }

        if (lastClassList.isEmpty()) {
            AndroidApi
                .findClassesByEnd(code)
                .map {
                    getClass(it)
                }
                .forEach {
                    it?.let { javaClass -> resultList.add(javaClass) }
                }
        } else {
            last.classList.forEach { lastClass ->
                if (last.isNewInstance) {
                    arrayOf(
                        getPublicField(lastClass, code),
                        getPublicMethod(lastClass, code),
                        getPublicStaticField(lastClass, code),
                        getPublicStaticMethod(lastClass, code)
                    )
                } else {
                    arrayOf(
                        getPublicStaticField(lastClass, code),
                        getPublicStaticMethod(lastClass, code)
                    )
                }.forEach {
                    it?.let { javaClass ->
                        last.isNewInstance = true
                        resultList.add(javaClass)
                    }
                }
            }
        }


        println("resultList:$resultList")
        if (resultList.isNotEmpty()) {
            last.classList = resultList
        }

        return last
    }

    private fun getClass(it: String): Class<*>? {
        return runCatching {
            LuaApplication.getInstance().classLoader.loadClass(it)
        }.getOrNull()
    }

    fun getAccessibleObjectText(accessibleObject: AccessibleObject): CharSequence {
        return when (accessibleObject) {
            is Method -> {
                accessibleObject.toString().run {
                    SpannableString(substring(indexOf("("))).apply {
                        setSpan(
                            AbsoluteSizeSpan(
                                14, true
                            ),
                            0,
                            length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                    }
                }
            }
            else -> ""
        }

    }

}