plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "cdr.authorizationlib"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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