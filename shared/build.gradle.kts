import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.moko.resources)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.skie)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions { jvmTarget.set(JvmTarget.JVM_1_8) }
            }
        }
    }

    val iosIntelSimulator = iosX64()
    val iosSiliconSimulator = iosSimulatorArm64()
    val iosPhysicalDevice = iosArm64()

    listOf(iosIntelSimulator, iosSiliconSimulator, iosPhysicalDevice).forEach {
        it.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
        }

        val commonMain by getting {
            dependencies {
                // Shared Resources
                api(libs.moko.resources)

                // Core MP stack
                implementation(libs.coroutines.core)
                implementation(libs.serialization.json)
                implementation(libs.datetime)
                implementation(libs.immutable)

                // Networking
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)

                // Logging
                implementation(libs.napier)

                // Key–value storage
                implementation(libs.settings.core)
                implementation(libs.settings.noarg)

                // SQL runtime
                implementation(libs.sqldelight.runtime)

                // DI
                implementation(libs.koin.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.coroutines.test)
                implementation(libs.ktor.client.mock)
                implementation(libs.turbine)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.sqldelight.android)
            }
        }

        val iosX64Main by getting
        val iosSimulatorArm64Main by getting
        val iosArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sqldelight.native)
            }
        }
    }
}

android {
    namespace = "dev.mingchungx.notizen"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

multiplatformResources {
    resourcesPackage.set("dev.mingchungx.notizen")
    resourcesClassName.set("SharedRes")
}

skie {
    features {
        enableSwiftUIObservingPreview = true
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("dev.mingchungx.notizen.db")
        }
    }
}
