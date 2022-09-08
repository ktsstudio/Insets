package ru.ktsstudio.sample.insets.ui.tappable

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TappableViewModel : ViewModel() {

    private val mutableVisibleState = MutableStateFlow(false)
    val visibleState: Flow<Boolean>
        get() = mutableVisibleState.asStateFlow()

    fun changeVisibleState() {
        mutableVisibleState.value = !mutableVisibleState.value
    }
}