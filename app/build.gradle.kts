plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.danamon.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.danamon.test"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "MOVIE_BASE_URL", "\"https://api.themoviedb.org/\"")
        buildConfigField("String", "LOAD_IMAGE", "\"https://image.tmdb.org/t/p/w500\"")
        buildConfigField("String", "TSDB_API_KEY", "\"3/\"")
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
    buildFeatures {
        viewBinding = true
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    implementation(libs.constraintlayout)

    implementation(libs.koin.android)
    implementation(libs.koin.core)
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.test.org)

    debugImplementation(libs.chucker.library)
    releaseImplementation(libs.chucker.library.no.op)

    implementation(libs.timber.library)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    implementation(libs.okhttp.library)
    implementation(libs.okhttp.logging.interceptor)
}