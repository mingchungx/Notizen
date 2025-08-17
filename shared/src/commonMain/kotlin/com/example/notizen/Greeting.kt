package com.example.notizen

import com.example.notizen.util.localized
import com.notizen.shared.SharedRes

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello from moko: ${SharedRes.strings.hello.localized()}"
    }
}