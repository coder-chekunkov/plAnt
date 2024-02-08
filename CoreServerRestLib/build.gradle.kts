plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "cdr.coreserver"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation ("org.mockito:mockito-core:4.8.0")
    testImplementation("io.mockk:mockk:1.13.9")

    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}