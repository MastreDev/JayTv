plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "kr.mastre.jaytv.tv"
    compileSdk = 34

    defaultConfig {
        applicationId = "kr.mastre.jaytv.tv"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.ktx)

    // compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose.tv)

    // hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // exo
    implementation(libs.bundles.exoplayer)

    testImplementation(libs.bundles.test.android.unit)

    androidTestImplementation(libs.bundles.test.android.ui)
}