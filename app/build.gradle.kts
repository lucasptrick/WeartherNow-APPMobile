plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.lpro.wearthernow"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.lpro.wearthernow"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val props = project.properties                                   // lê local.properties
        buildConfigField(
            "String",
            "OWM_KEY",
            "\"5323953037f43b8f9991ef4f03c0a79c\""
//            "\"${props["OWM_KEY"] ?: ""}\""                            // coloca na BuildConfig
        )

    }

    // Habilite Compose
    buildFeatures {
        compose = true
        buildConfig = true
    }
//    composeOptions {
//        // Versão do plugin do compilador (combine com o BOM)
//        kotlinCompilerExtensionVersion = "1.8.3"
//    }

    // (Opcional, mas recomendado se já usa JDK 17/AGP 8+)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.material3.android)
    implementation(libs.play.services.contextmanager) {
        exclude(group = "com.android.support", module = "support-v4")
    }

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.activity:activity-compose:1.10.1")

    // Retrofit + conversor Gson
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle (ViewModel + livedata/flow)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Coil para ícone do clima
    implementation(libs.coil.compose)

    // Jetpack Compose — BOM ✓
    implementation(libs.androidx.compose.bom) // junho/25, última estável :contentReference[oaicite:0]{index=0}

    implementation(platform("androidx.compose:compose-bom:2025.06.01"))

    // núcleo Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation(libs.androidx.ui.tooling)

    // ViewModel + Compose integration  ✅
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1")
}