import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    `java-library`
    `maven-publish`
}

group = "io.github.u1tramarinet.gradleplugins.buildlogic"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    setProperty("archivesBaseName", "gradle-plugins")
    plugins {
        register("androidApplication") {
            id = "io.github.u1tramarinet.gradleplugins.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["java"])

                groupId = "io.github.u1tramarinet.gradleplugins.buildlogic"
                artifactId = "gradle-plugins"
                version = "1.0.0"
            }
        }
    }
}
