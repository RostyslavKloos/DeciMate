import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.named
import ua.rodev.decimate.libs

class AndroidDetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            libs.detekt.gradle.plugin.get()
            pluginManager.apply(libs.detekt.gradle.plugin.get().group.toString())

            val extension = extensions.getByType<DetektExtension>()
            extension.apply {
                tasks.named<Detekt>("detekt") {
                    buildUponDefaultConfig = true
                    config.setFrom(files("$rootDir/.detekt/config.yml"))
                    outputs.upToDateWhen { false }
                    reports {
                        html.required.set(true)
                        sarif.required.set(false)
                        md.required.set(false)
                        xml.required.set(false)
                        txt.required.set(false)
                    }
                    include("**/*.kt", "**/*.kts")
                    exclude("**/resources/**", "**/build/**")
                    parallel = true
                    buildUponDefaultConfig = true
                    allRules = true
                }
                dependencies {
                    "detektPlugins"(libs.detekt.ruleset.ktlint)
                }
            }
        }
    }
}
