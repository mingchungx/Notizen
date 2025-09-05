# Notizen

Honestly, still not sure what this project is meant to be. Mainly just exploring Kotlin Multiplatform and integration with iOS and Android using the latest native mobile dev tools :)

### Installation

```bash
git clone https://github.com/mingchungx/Notizen.git
```

You will need to install Java v17 and Ruby v2.6.10. [jEnv](https://github.com/jenv/jenv) is a useful Java version manager. [asdf](https://asdf-vm.com) is a recommended Ruby version manager. 

It is also recommended to use the latest versions of Android Studio (for Android + KMP development) and Xcode (iOS development) on macOS with Apple Silicion architecture.

The `Kotlin Multiplatform` plugin is also required for Android Studio.

### Shared

The `shared/` directory contains the shared business logic and data layers for iOS and Android (Kotlin Multiplatform).

### iOS App

The `iosApp/` directory contains the code for the iOS app (Swift / SwiftUI). To run it in Xcode, run the Fastlane script to build and generate the project:

```bash
fastlane build_xc_project arch:SimulatorArm64 configuration:Debug
```

Supported architectures: `X64`, `SimulatorArm64`, `Arm64`

Supported configurations: `Debug`, `Release`

Behind the scenes, this Ruby script will generate shared resources, manage XC frameworks, bundle, and use Tuist to generate a Xcode project.

### Android App

The `androidApp/` directory contains the code for the Android app (Kotlin / Jetpack Compose). It can be run directly in Android Studio.


