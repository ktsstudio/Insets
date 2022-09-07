package ru.ktsstudio.sample.insets.ui.samples.fullscreen

import androidx.compose.runtime.Composable
import ru.ktsstudio.sample.insets.ui.samples.BaseComposeActivity
import ru.ktsstudio.sample.insets.ui.theme.InsetsExamplesTheme
import ru.ktsstudio.sample.insets.utils.rememberSystemUiVisibilityController
import ru.ktsstudio.sample.insets.utils.setDisplayCutoutModeAlways
import ru.ktsstudio.sample.insets.utils.toggleUi

class FullscreenStableComposeActivity : BaseComposeActivity() {

    override fun setupOnCreate() {
        window.setDisplayCutoutModeAlways()
    }

    @Composable
    override fun Sample() {
        val systemUiVisibilityController = rememberSystemUiVisibilityController()
        InsetsExamplesTheme {
            FullscreenStableSample(
                toggleUi = systemUiVisibilityController.toggleUi,
                isSystemUiVisible = systemUiVisibilityController.isVisible
            )
        }
    }
}