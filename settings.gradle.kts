rootProject.name = "plAnt"
include(":plAnt-Mobile")
include(":Core:CoreComposeDesignSystemLib")
include(":Core:CoreResourcesLib")
include(":Core:CoreUtilsLib")
include(":Feature:AuthorizationLib")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") {
            library("kotlin-core", "androidx.core:core-ktx:1.12.0")
            library("androidx-lifecycle", "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
            library("androidx-lifecycle-compose", "androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
            library("androidx-compose-material", "com.google.android.material:material:1.5.0")
            library("androidx-compose-material3", "androidx.compose.material3:material3:1.2.1")
            library("androidx-compose-tooling", "androidx.compose.ui:ui-tooling:1.6.4")
            library("androidx-fragment", "androidx.fragment:fragment-ktx:1.6.2")
            library("retrofit2", "com.squareup.retrofit2:retrofit:2.9.0")
            library("retrofit2-converter", "com.squareup.retrofit2:converter-gson:2.9.0")
            library("google-truth", "com.google.truth:truth:1.2.0")
            library("junit-jupiter-api", "org.junit.jupiter:junit-jupiter-api:5.8.2")
            library("junit-jupiter-engine", "org.junit.jupiter:junit-jupiter-engine:5.8.2")
        }
    }
}

/**
 * use in feature modules this region to implement dependencies:
 *
 * implementation(libs.kotlin.core)
 * implementation(libs.androidx.lifecycle)
 * implementation(libs.androidx.lifecycle.compose)
 * implementation(libs.androidx.compose.material)
 * implementation(libs.androidx.compose.material3)
 * implementation(libs.androidx.fragment)
 * implementation(libs.retrofit2)
 * implementation(libs.retrofit2.converter)
 * testImplementation(libs.google.truth)
 * testImplementation(libs.junit.jupiter.api)
 * testRuntimeOnly(libs.junit.jupiter.engine)
 * debugImplementation(libs.androidx.compose.tooling)
 *
 * @author Alexandr Chekunkov
 */

/**
 * use this region to implement modules:
 *
 * pattern: implementation(project(":PACKAGE:MODULE_NAME"))
 * example: implementation(project(":Core:CoreComposeDesignSystemLib"))
 *
 * @author Alexandr Chekunkov
 */
