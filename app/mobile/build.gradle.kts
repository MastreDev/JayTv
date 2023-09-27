plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.services)
}

android {
    namespace = "kr.mastre.jaytv"
    compileSdk = 34

    defaultConfig {
        applicationId = "kr.mastre.jaytv"
        minSdk = 26
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
            isMinifyEnabled = true //코드 최적화
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(":feature:player"))
    implementation(project(":playlist:data"))

    // compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose.mobile)
    debugImplementation(libs.compose.ui.tooling)

    // coil
    implementation(libs.bundles.coil)

    // exo
    implementation(libs.bundles.exoplayer)

    // hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.config)

    testImplementation(libs.bundles.test.android.unit)

    androidTestImplementation(libs.bundles.test.android.ui)
}