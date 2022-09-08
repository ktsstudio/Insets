package ru.ktsstudio.sample.insets.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.Window
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.accompanist.systemuicontroller.SystemUiController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/*
Implementation based on Accompanist rememberSystemUiController:
Updates system bars visibility in one
Provides StateFlow of ui visibility
Sets up system bars behavior to immersive sticky mode
 */
@Composable
fun rememberSystemUiVisibilityController(window: Window? = findWindow()): SystemUiVisibilityController {
    val view = LocalView.current
    return remember(view) { AndroidSystemUiVisibilityController(window, view) }
}

interface SystemUiVisibilityState {
    val isVisible: StateFlow<Boolean>
}

interface SystemUiVisibilityController : SystemUiVisibilityState {
    var isSystemBarsVisible: Boolean
}

internal class AndroidSystemUiVisibilityController(
    window: Window?,
    private val view: View
) : SystemUiVisibilityController {

    private val windowInsetsController = window?.let {
        WindowInsetsControllerCompat(window, view).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private val isVisibleStateFlow = MutableStateFlow(isSystemBarsVisible)

    private fun systemUiBars() =
        WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars()

    override var isSystemBarsVisible: Boolean
        get() {
            return ViewCompat.getRootWindowInsets(view)
                ?.isVisible(systemUiBars()) == true
        }
        set(value) {
            if (value) {
                windowInsetsController?.show(systemUiBars())
            } else {
                windowInsetsController?.hide(systemUiBars())
            }
            isVisibleStateFlow.value = value
        }

    override val isVisible: StateFlow<Boolean>
        get() = isVisibleStateFlow.asStateFlow()
}

val SystemUiVisibilityController.toggleUi: () -> Unit
    get() = {
        isSystemBarsVisible = !isSystemBarsVisible
    }

@Composable
private fun findWindow(): Window? =
    (LocalView.current.parent as? DialogWindowProvider)?.window
        ?: LocalView.current.context.findWindow()

private tailrec fun Context.findWindow(): Window? =
    when (this) {
        is Activity -> window
        is ContextWrapper -> baseContext.findWindow()
        else -> null
    }