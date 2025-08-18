import SwiftUI
import Shared

extension Image {
    init(resource: KeyPath<SharedRes.images, Shared.ResourcesImageResource>) {
        self.init(uiImage: SharedRes.images()[keyPath: resource].toUIImage()!)
    }
}
