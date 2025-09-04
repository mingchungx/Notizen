// swift-tools-version: 5.9
import PackageDescription

#if TUIST
    import ProjectDescription

    let packageSettings = PackageSettings(
        // Customize the product types for specific package product
        // Default is .staticFramework
        // productTypes: ["Alamofire": .framework,]
        productTypes: [:]
    )
#endif

let package = Package(
    name: "Notizen",
    dependencies: [
        .package(url: "https://github.com/apple/swift-collections.git", .upToNextMajor(from: "1.2.1")),
        .package(url: "https://github.com/apple/swift-algorithms.git", .upToNextMajor(from: "1.2.1")),
        .package(url: "https://github.com/onevcat/Kingfisher", .upToNextMajor(from: "7.12.0")),
        .package(url: "https://github.com/EmergeTools/Pow.git", .upToNextMajor(from: "1.0.5")),
        .package(url: "https://github.com/twostraws/Vortex.git", .upToNextMajor(from: "1.0.3")),
        .package(url: "https://github.com/SwiftUIX/SwiftUIX.git", .upToNextMajor(from: "0.2.3")),
        .package(url: "https://github.com/rickclephas/KMP-ObservableViewModel.git", from: "1.0.0-BETA-13"),
    ]
)
