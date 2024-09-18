@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("commonLibs") {
            from(files("./gradle/commonLibs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")