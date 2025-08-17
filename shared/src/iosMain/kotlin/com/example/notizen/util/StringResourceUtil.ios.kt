package com.example.notizen.util

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual fun StringResource.localized(): String {
    return StringDesc.Resource(this).localized()
}