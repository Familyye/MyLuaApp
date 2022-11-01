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

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(BuildConfig.Libs.Tools.androlua_standalone)

    implementation(BuildConfig.Libs.Tools.multi_languages)
    implementation(BuildConfig.Libs.Tools.mmkv)
    implementation(BuildConfig.Libs.Google.gson)
    implementation(BuildConfig.Libs.Google.material)
    implementation(BuildConfig.Libs.Tools.zip4j)
    implementation(BuildConfig.Libs.AndroidX.appcompat)
    implementation(BuildConfig.Libs.Default.kotlinx_coroutines_android)
}