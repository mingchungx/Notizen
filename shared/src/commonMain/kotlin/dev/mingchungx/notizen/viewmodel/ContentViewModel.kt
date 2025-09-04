package dev.mingchungx.notizen.viewmodel

import dev.mingchungx.notizen.repository.GreetingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel(
    private val greetingRepository: GreetingRepository
) : BaseViewModel() {
    sealed class Action {
        data object Increment : Action()
        data object FetchGreeting : Action()
    }

    private val _countFlow = MutableStateFlow(0)
    val countFlow = _countFlow.asStateFlow()

    private val _textFlow = MutableStateFlow("")
    val textFlow = _textFlow.asStateFlow()

    fun onAction(action: Action) {
        when (action) {
            Action.Increment -> {
                _countFlow.update { it + 1 }
            }
            Action.FetchGreeting -> {
                scope.launch {
                    val result = greetingRepository.fetchGetting()
                    _textFlow.update { result }
                }
            }
        }
    }
}