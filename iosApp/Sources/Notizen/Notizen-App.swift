import SwiftUI
import Shared

@main
struct NotizenApp: App {
    init() {
        let _ = doInitKoin(extra: KotlinArray(size: 1, init: { _ in iosModule }))
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
