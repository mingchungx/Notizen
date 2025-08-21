# Notizen

Honestly, still not sure what this project is meant to be. Mainly just exploring Kotlin Multiplatform and integration with iOS and Android using the latest native mobile dev tools :)

### Installation

```bash
git clone https://github.com/mingchungx/Notizen.git
```

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

The `androidApp/` directory contains the code for the Android app (Kotlin / Jetpack Compose). It can be run in Android Studio.


