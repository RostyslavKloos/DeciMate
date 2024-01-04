import org.gradle.api.Plugin
import org.gradle.api.Project
import ua.rodev.decimate.configureKotlinJvm

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            configureKotlinJvm()
        }
    }
}
