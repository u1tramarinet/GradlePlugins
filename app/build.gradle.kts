plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.dependency.guard)
    alias(libs.plugins.build.logic.application)
}

android {
    namespace = "io.github.u1tramarinet.gradleplugins"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.u1tramarinet.gradleplugins"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.runtime)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

dependencyGuard {
    configuration("releaseRuntimeClasspath") {
        tree = true
        modules = true
        allowedFilter = {
            !it.contains("test")
        }
    }
    configuration("debugRuntimeClasspath") {
        tree = true
        allowedFilter = {
            if (it.contains("test")) {
                println("[test] $it")
            }
            true
        }
    }
}