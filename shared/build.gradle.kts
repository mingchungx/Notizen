import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    val iosIntelSimulator = iosX64()
    val iosSiliconSimulator = iosSimulatorArm64()
    val iosPhysicalDevice = iosArm64()

    listOf(
        iosIntelSimulator,
        iosSiliconSimulator,
        iosPhysicalDevice
    ).forEach {
        it.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

    tasks.register("assembleIntelSimulatorFramework") {
        group = "build"
        description = "Assemble Intel macOS iOS simulator framework"
        dependsOn(iosIntelSimulator.binaries.getFramework("DEBUG").linkTaskName)
        dependsOn(iosIntelSimulator.binaries.getFramework("RELEASE").linkTaskName)
    }

    tasks.register("assembleSiliconSimulatorFramework") {
        group = "build"
        description = "Assemble Apple Silicon iOS simulator framework"
        dependsOn(iosSiliconSimulator.binaries.getFramework("DEBUG").linkTaskName)
        dependsOn(iosSiliconSimulator.binaries.getFramework("RELEASE").linkTaskName)
    }

    tasks.register("assemblePhysicalDeviceFramework") {
        group = "build"
        description = "Assemble physical iOS device framework"
        dependsOn(iosPhysicalDevice.binaries.getFramework("DEBUG").linkTaskName)
        dependsOn(iosPhysicalDevice.binaries.getFramework("RELEASE").linkTaskName)
    }

    tasks.register("assembleSharedXCFramework") {
        group = "build"
        description = "Assemble all frameworks for Xcode"
        dependsOn(
            "assemblePhysicalDeviceFramework",
            "assembleIntelSimulatorFramework",
            "assembleSiliconSimulatorFramework"
        )
    }
}

android {
    namespace = "com.example.notizen"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
