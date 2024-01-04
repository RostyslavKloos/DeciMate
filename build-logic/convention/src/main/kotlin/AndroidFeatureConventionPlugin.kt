import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import ua.rodev.decimate.libs

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("wallpaper.android.library")
                apply("wallpaper.android.hilt")
            }
            dependencies {
                add("implementation", project(":designsystem"))
//                add("implementation", project(":ui"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))
                add("implementation", libs.kotlin.coroutines.android.get())
            }
        }
    }
}
