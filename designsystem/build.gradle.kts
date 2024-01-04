plugins {
    alias(libs.plugins.decimate.android.library)
    alias(libs.plugins.decimate.android.library.compose)
}

android {
    namespace = "ua.rodev.designsystem"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    api(libs.core.ktx)
    api(libs.compose.material3)
    api(libs.compose.ui.graphics)
    api(libs.compose.ui)
    api(libs.compose.ui.tooling.preview)
}
