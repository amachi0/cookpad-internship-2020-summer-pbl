package dependencies

object Dep {
    object GradlePlugin {
        val android = "com.android.tools.build:gradle:3.6.0"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
        val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${AndroidX.Navigation.version}"
        val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
        val design = "com.google.android.material:material:1.1.0-rc01"
        val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"
        val preference = "androidx.preference:preference:1.1.0"
        val activityKtx = "androidx.activity:activity-ktx:1.1.0"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.1"
        val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        val liveDataViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"

        object Navigation {
            val version = "2.2.1"
            val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$version"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }
    }

    object Kotlin {
        val version = "1.4.0"
        val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
        val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        val coroutinesVersion = "1.3.3"
        val coroutinesCommon =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        val androidCoroutinesDispatcher =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
        val coroutinesPlayServices =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
        val serializationVersion = "0.14.0"
        val serializationCommon =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationVersion"
        val serializationAndroid =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion"
    }

    object Firebase {
        val core = "com.google.firebase:firebase-core:16.0.4"
        val firestoreKtx = "com.google.firebase:firebase-firestore-ktx:21.2.1"
        val storageKtx = "com.google.firebase:firebase-storage-ktx:19.1.1"
    }

    object Dagger {
        val version = "2.26"
        val core = "com.google.dagger:dagger:$version"
        val compiler = "com.google.dagger:dagger-compiler:$version"
        val androidSupport = "com.google.dagger:dagger-android-support:$version"
        val android = "com.google.dagger:dagger-android:$version"
        val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
        val assistedInjectAnnotations =
            "com.squareup.inject:assisted-inject-annotations-dagger2:0.5.2"
        val assistedInjectProcessor = "com.squareup.inject:assisted-inject-processor-dagger2:0.5.2"
    }

    object Test {
        val junit = "junit:junit:4.12"
        val testRunner = "androidx.test:runner:1.3.0-alpha02"
        val testRules = "androidx.test:rules:1.3.0-alpha02"
        val testCoreKtx = "androidx.test:core-ktx:1.2.1-alpha02"
        val androidJunit4Ktx = "androidx.test.ext:junit-ktx:1.1.2-alpha02"
        val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"

        val jvmModuleTest = "org.jetbrains.kotlin:kotlin-test"
        val jvmModuleTestJunit = "org.jetbrains.kotlin:kotlin-test-junit"
        val commonModuleTest = "org.jetbrains.kotlin:kotlin-test-common"
        val commonModuleTestAnnotations = "org.jetbrains.kotlin:kotlin-test-annotations-common"
    }

    object Groupie {
        val version = "2.7.2"
        val groupie = "com.xwray:groupie:$version"
        val databinding = "com.xwray:groupie-databinding:$version"
    }
}
