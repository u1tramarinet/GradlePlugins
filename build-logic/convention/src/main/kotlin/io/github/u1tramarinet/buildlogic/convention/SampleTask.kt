package io.github.u1tramarinet.buildlogic.convention

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Project
import java.util.Locale

internal fun Project.configureSampleTask(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
) {
    androidComponentsExtension.onVariants {variant ->
        tasks.register("execute${variant.name.capitalize()}sampleTask") {
            doLast {
                println("execute ${variant.name} sample task")
            }
        }
    }
}

private fun String.capitalize() = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}