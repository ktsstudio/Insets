package ru.ktsstudio.sample.insets.ui.samples.gestures

import androidx.compose.runtime.Composable
import ru.ktsstudio.sample.insets.ui.samples.BaseComposeActivity
import ru.ktsstudio.sample.insets.ui.theme.InsetsExamplesTheme

class MandatoryGestureComposeActivity : BaseComposeActivity() {

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            MandatoryGestureSample()
        }
    }
}