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
                .framework(path: "Frameworks/Shared.framework"),
                .external(name: "Kingfisher"),
            ], 
            settings: .settings(configurations: [ 
                .debug(name: "Debug", xcconfig: "./xcconfigs/Notizen.xcconfig"), 
                .release(name: "Release", xcconfig: "./xcconfigs/Notizen.xcconfig"), 
            ]) 
        ), 
    ]
)
