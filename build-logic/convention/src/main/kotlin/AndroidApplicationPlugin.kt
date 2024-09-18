import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import io.github.u1tramarinet.buildlogic.convention.commonLibs
import io.github.u1tramarinet.buildlogic.convention.configureSampleTask
import io.github.u1tramarinet.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            val appPatch = libs.findVersion("appPatch")
            val appPatchCommon = commonLibs.findVersion("appPatch")
            println("appPatch: $appPatch, appPatchCommon: $appPatchCommon")
            configureSampleTask(extensions.getByType<ApplicationAndroidComponentsExtension>())
        }
    }
}