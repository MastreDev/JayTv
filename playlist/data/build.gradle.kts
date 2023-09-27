plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "kr.mastre.playlist.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kapt {
        correctErrorTypes = true
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {

    implementation(project(":playlist"))

    // firebase Remote Config
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.config)

    implementation(libs.rxKotlin)
    implementation(libs.coroutinesToRx3)

    implementation(libs.kotlin.serialization.json)

    // hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.bundles.test.android.unit)

    androidTestImplementation(libs.bundles.test.android.ui)
}