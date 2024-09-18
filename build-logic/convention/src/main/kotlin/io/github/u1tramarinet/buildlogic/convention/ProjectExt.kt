package io.github.u1tramarinet.buildlogic.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.commonLibs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("commonLibs")
