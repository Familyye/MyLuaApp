import android.annotation.SuppressLint
import com.android.build.api.dsl.LintOptions

plugins {
    id("com.android.library")
    id("kotlin-android")
}


android {
    compileSdk = BuildConfig.Config.Default.compileSdk
    buildToolsVersion = BuildConfig.Config.Default.buildToolsVersion

    defaultConfig {
        minSdk = BuildConfig.Config.Default.minSdk
        targetSdk = BuildConfig.Config.Default.targetSdk


        // Required when setting minSdkVersion to 20 or lower
        multiDexEnabled = true

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lint {
        isAbortOnError = false
    }

    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
    kotlinOptions {
        jvmTarget = "1.11"
    }

    configurations { 
        all { 
            exclude(module= "httpclient")
        }
    }
}

dependencies {
    implementation(BuildConfig.Libs.Tools.joni)
    implementation(BuildConfig.Libs.Tools.jcodings)
    api(BuildConfig.Libs.Google.gson)
    implementation(BuildConfig.Libs.Tools.batik_css)
    implementation(BuildConfig.Libs.Tools.batik_util)
    implementation(BuildConfig.Libs.Tools.dom)
    coreLibraryDesugaring(BuildConfig.Libs.Tools.desugar_jdk_libs)
}