plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.anvil)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.viewRenderer.api"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    api(project(":data:api"))
    api(libs.dagger)
    api(libs.anvil.annotations)
    kapt(libs.dagger.compiler)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}