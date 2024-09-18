pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("commonLibs") {
            from(files("./build-logic/gradle/commonLibs.versions.toml"))
        }
    }
}

rootProject.name = "GradlePlugins"
include(":app")
include(":extapp")
