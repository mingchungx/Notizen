package dev.mingchungx.notizen.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel {
    private val job = SupervisorJob()
    protected val scope = CoroutineScope(Dispatchers.Main + job)

    open fun onLaunch() {}

    open fun onCleared() { scope.cancel() }
}