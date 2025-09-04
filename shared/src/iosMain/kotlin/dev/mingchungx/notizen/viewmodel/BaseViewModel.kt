package dev.mingchungx.notizen.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel : ViewModel() {
    private val job = SupervisorJob()
    protected val scope = CoroutineScope(Dispatchers.Main.immediate + job)

    open fun onLaunch() {}

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}