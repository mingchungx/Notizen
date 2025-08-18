package com.example.notizen

import com.example.notizen.util.localized
import com.notizen.shared.SharedRes
import dev.icerock.moko.resources.ImageResource

class Greeting {
    private val platform: Platform = getPlatform()
    public val image: ImageResource = SharedRes.images.cat

    fun greet(): String {
        return "Hello from moko: ${SharedRes.strings.hello.localized()}"
    }
}