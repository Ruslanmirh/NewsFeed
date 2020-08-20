plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "ru.mirkhusainov.newsfeed"
        minSdkVersion(26)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "ENDPOINT", "\"https://newsapi.org/v2/\"")
        buildConfigField("String", "API_KEY", "\"26eddb253e7840f988aec61f2ece2907\"")

    }

    buildTypes {
        getByName("release") {
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
}

object Dependencies {
    const val moxy_version = "2.1.2"
    const val constrained_version = "1.1.3"
    const val retrofit_version = "2.5.0"

    const val cicerone_version = "5.0.0"
    const val rx_java_version = "2.2.2"
    const val rx_android_version = "2.0.2"

    const val moshi_version = "2.4.0"
    const val toothpick_version = "3.0.2"

    const val permissions_version = "0.10.2"
    const val picasso_version = "2.71828"

    const val material_version = "1.1.0-beta01"
    const val recyclerview_version = "1.1.0-beta05"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    //Design
    implementation("com.google.android.material:material:${Dependencies.material_version}")
    implementation("androidx.recyclerview:recyclerview:${Dependencies.recyclerview_version}")

    //Moxy
    implementation("com.github.moxy-community:moxy:${Dependencies.moxy_version}")
    implementation("com.github.moxy-community:moxy-ktx:${Dependencies.moxy_version}")
    implementation("com.github.moxy-community:moxy-androidx:${Dependencies.moxy_version}")
    kapt("com.github.moxy-community:moxy-compiler:${Dependencies.moxy_version}")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Dependencies.retrofit_version}")
    implementation("com.squareup.retrofit2:converter-gson:${Dependencies.retrofit_version}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${Dependencies.retrofit_version}")

    implementation("com.squareup.retrofit2:converter-moshi:${Dependencies.moshi_version}")

    //Cicerone
    implementation("ru.terrakok.cicerone:cicerone:${Dependencies.cicerone_version}")

    //RxJava
    implementation("io.reactivex.rxjava2:rxjava:${Dependencies.rx_java_version}")
    implementation("io.reactivex.rxjava2:rxandroid:${Dependencies.rx_android_version}")

    //Toothpick
    implementation("com.github.stephanenicolas.toothpick:ktp:${Dependencies.toothpick_version}")
    kapt("com.github.stephanenicolas.toothpick:toothpick-compiler:${Dependencies.toothpick_version}")

    //Picasso
    implementation("com.squareup.picasso:picasso:${Dependencies.picasso_version}")
}