import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import ua.rodev.decimate.configureAndroidCompose
import ua.rodev.decimate.configureKotlinAndroid
import ua.rodev.decimate.libs

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = libs.versions.targetSdk.get().toInt()
            }
            configureAndroidCompose(extensions.getByType<ApplicationExtension>())
        }
    }
}
