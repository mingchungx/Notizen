package dev.mingchungx.notizen.util

import dev.icerock.moko.resources.StringResource
import dev.mingchungx.notizen.appContext

actual fun StringResource.localized(): String {
    return this.getString(appContext)
}