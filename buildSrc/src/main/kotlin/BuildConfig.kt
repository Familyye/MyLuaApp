/**
 * @author: dingyi
 * @date: 2021/10/13 15:21
 * @description:
 **/

object BuildConfig {


    object Config {

        object Default {

            const val targetSdk = 30
            const val minSdk = 21
            const val buildToolsVersion = "30.0.3"
            const val compileSdk = 30
        }

        object App {
            const val versionCode = 19
            const val versionName = "0.3.10(alpna)"
            const val packageName = "com.dingyi.MyLuaApp"

        }
    }

    object Versions {
        const val kotlin_version = "1.5.30"
        const val android_gradle_plugin_version = "7.0.2"
        const val antlr_kotlin_version = "6304d5c1c4"
        const val gson_version = "2.8.8"
        const val material_version = "1.5.0-alpha01"
        const val appcompat_version = "1.4.0-alpha03"
        const val code_editor_version = "0.6.0-dev-4"
        const val lifecycle_version = "2.4.0-alpha01"
        const val preference_ktx_version = "1.1.1"
        const val constraintlayout_version = "2.0.4"
        const val drakeet_about_version = "2.4.1"
        const val drakeet_multitype_version = "4.0.0"
        const val litepal_version = "3.2.3"
        const val glide_version = "4.11.0"
        const val easy_http_version = "10.2"
        const val okhttp3_version = "4.9.0"
        const val livedatbus_version = "1.0.1"
        const val swiperefreshlayout_version = "1.2.0-alpha01"
        const val desugar_jdk_libs_version = "1.1.5"
        const val lsp4j_version = "0.12.0"
        const val joni_version = "2.1.11"
        const val jcodings_version = "1.0.18"
        const val xmlgraphics_version = "1.14"
        const val dom_version = "2.3.0-jaxb-1.0.6"
    }

    object Libs {

        object Plugin {
            const val kotlin_gradle_plugin =
                "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
            const val android_gradle_plugin =
                "com.android.tools.build:gradle:${Versions.android_gradle_plugin_version}"
            const val antlr_kotlin_gradle_plugin =
                "com.strumenta.antlr-kotlin:antlr-kotlin-gradle-plugin:${Versions.antlr_kotlin_version}"
        }

        object Google {
            const val gson = "com.google.code.gson:gson:${Versions.gson_version}"
            const val material = "com.google.android.material:material:${Versions.material_version}"
        }

        object AndroidX {
            const val lifecycle_livedata =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
            const val lifecycle_viewmodel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
            const val lifecycle_runtime =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
            const val constraintlayout =
                "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout_version}"
            const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
            const val preference_ktx =
                "androidx.preference:preference-ktx:${Versions.preference_ktx_version}"
            const val swiperefreshlayout =
                "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout_version}"

        }

        object Default {
            const val kotlin_stdlib =
                "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin_version}"
            const val glide_compiler =
                "com.github.bumptech.glide:compiler:${Versions.glide_version}"
            const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"

        }

        object Tools {

            const val desugar_jdk_libs =
                "com.android.tools:desugar_jdk_libs:${Versions.desugar_jdk_libs_version}"

            const val litepal = "org.litepal.guolindev:core:${Versions.litepal_version}"

            const val livedatbus = "com.github.zhudaihao:livedatbus-master:${Versions.livedatbus_version}"

            const val lsp4j = "org.eclipse.lsp4j:org.eclipse.lsp4j:${Versions.lsp4j_version}"

            const val antlr_kotlin_runtime = "com.strumenta.antlr-kotlin:antlr-kotlin-runtime:${Versions.antlr_kotlin_version}"

            const val antlr_kotlin_target = "com.strumenta.antlr-kotlin:antlr-kotlin-target:${Versions.antlr_kotlin_version}"

            const val joni = "org.jruby.joni:joni:${Versions.joni_version}"

            const val jcodings = "org.jruby.jcodings:jcodings:${Versions.jcodings_version}"

            const val batik_css = "org.apache.xmlgraphics:batik-css:${Versions.xmlgraphics_version}"
            const val batik_util = "org.apache.xmlgraphics:batik-util:${Versions.xmlgraphics_version}"
            const val dom = "org.w3c:dom:${Versions.dom_version}"
        }

        object Views {
            const val code_editor =
                "io.github.Rosemoe.sora-editor:editor:${Versions.code_editor_version}"
            const val drakeet_about = "com.drakeet.about:about:${Versions.drakeet_about_version}"
            const val drakeet_multitype = "com.drakeet.multitype:multitype:${Versions.drakeet_multitype_version}"

        }
        object Network {
            const val easy_http = "com.github.getActivity:EasyHttp:${Versions.easy_http_version}"
            const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3_version}"
        }

    }


}