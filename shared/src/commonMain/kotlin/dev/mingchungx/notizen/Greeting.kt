package dev.mingchungx.notizen

import dev.mingchungx.notizen.util.localized
import dev.icerock.moko.resources.ImageResource
import dev.mingchungx.notizen.SharedRes

class Greeting {
    private val platform: Platform = getPlatform()
    public val image: ImageResource = SharedRes.images.cat

    fun greet(): String {
        return "Hello from moko: ${SharedRes.strings.hello.localized()}"
    }
}