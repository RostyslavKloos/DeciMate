plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.detekt.compiler) apply false
}
