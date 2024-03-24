plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "cdr.plant"
    compileSdk = 34

    defaultConfig {
        applicationId = "cdr.plant"
        minSdk = 24

        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions { jvmTarget = "1.8" }
    composeOptions { kotlinCompilerExtensionVersion = "1.4.3" }
    buildFeatures { compose = true }
    tasks.withType<Test> { useJUnitPlatform() }
}

dependencies {
    // module dependencies region
    implementation(project(":Core:CoreComposeDesignSystemLib"))
    implementation(project(":Core:CoreUtilsLib"))
    implementation(project(":Core:CoreResourcesLib"))
    implementation(project(":Feature:AuthorizationLib"))
    // end region

    // dependencies for feature module region
    implementation(libs.kotlin.core)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.lifecycle.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.fragment)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter)
    testImplementation(libs.google.truth)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    debugImplementation(libs.androidx.compose.tooling)
    // end region
}