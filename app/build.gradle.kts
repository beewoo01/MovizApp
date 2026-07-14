plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)

    id("com.google.devtools.ksp") version "2.3.9"
}

android {
    namespace = "com.example.movizapp"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.movizapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}


/*
*
* API 읽기 액세스 토큰
* eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYWMxYjRlYjUxZjljYmZiYWRkMjQ1NzVmOTIzYTI4ZiIsIm5iZiI6MTc4MzQ4MTAxNS44OTUsInN1YiI6IjZhNGRjMmI3ODU2ZmM3MmE1MWY5MDI3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7pBIAvK4Ak35bnoLQ-OdLPlaBSKRhyENTaZN1sWhEfA
*
* API 키
* 2ac1b4eb51f9cbfbadd24575f923a28f
*
* */

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)


    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Room DB
    implementation(libs.androidx.room.runtime)

    ksp(libs.androidx.room.compiler)

    // Coroutine
    implementation(libs.androidx.room.ktx)

    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // View Model
    implementation(libs.androidx.lifecycle.viewmodel.compose)


    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}