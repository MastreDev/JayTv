plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}
android {
    namespace = "kr.mastre.feature.player"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    kapt {
        correctErrorTypes = true
    }
}
dependencies {

    implementation(project(":playlist"))

    implementation(libs.androidx.ktx)

    //compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose.mobile)
    debugImplementation(libs.compose.ui.tooling)

    // coil
    implementation(libs.bundles.coil)

    // hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // orbit
    implementation(libs.bundles.orbit)

    // rx
    implementation(libs.rxKotlin)
    implementation(libs.coroutinesToRx3)

    // exo
    implementation(libs.bundles.exoplayer)

    testImplementation(libs.bundles.test.android.unit)

    androidTestImplementation(libs.bundles.test.android.ui)
}