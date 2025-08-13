import ProjectDescription

let project = Project(
    name: "Notizen",
    settings: .settings(configurations: [
        .debug(name: "Debug", xcconfig: "./xcconfigs/Notizen-Project.xcconfig"), 
        .release(name: "Release", xcconfig: "./xcconfigs/Notizen-Project.xcconfig"), 
    ]),
    targets: [
        .target( 
            name: "Notizen", 
            destinations: .iOS, 
            product: .app,
            bundleId: "dev.tuist.notizen", 
            sources: ["Sources/Notizen/**"], 
            dependencies: [ 
                // TODO: This needs to be manually configured
                .framework(path: "../shared/build/bin/iosSimulatorArm64/debugFramework/Shared.framework"),
                .external(name: "Kingfisher"),
            ], 
            settings: .settings(configurations: [ 
                .debug(name: "Debug", xcconfig: "./xcconfigs/Notizen.xcconfig"), 
                .release(name: "Release", xcconfig: "./xcconfigs/Notizen.xcconfig"), 
            ]) 
        ), 
    ]
)
