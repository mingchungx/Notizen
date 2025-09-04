package dev.mingchungx.notizen.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UiState(
    val title: String = "Hello",
    val count: Int = 0,
    val isLoading: Boolean = false
)

class ContentViewModel : ViewModel() {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main.immediate + job)

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun increment() = _uiState.update { it.copy(count = it.count + 1) }

    fun load() {
        if (_uiState.value.isLoading) return
        _uiState.update { it.copy(isLoading = true) }
        scope.launch {
            delay(100)
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}