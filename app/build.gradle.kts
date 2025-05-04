plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safeargs.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.edu.biblioteca_musica"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.edu.biblioteca_musica"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.gson.serializer)
    implementation(libs.converter.gson)
    implementation(libs.retrofit)
    implementation(libs.coil.compose)
    implementation(libs.koin.android)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp)

    implementation(libs.room.runtime)
    implementation(libs.room.coroutines)
    ksp(libs.room.ksp)
    implementation(libs.okhttp.log.interceptor)
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}