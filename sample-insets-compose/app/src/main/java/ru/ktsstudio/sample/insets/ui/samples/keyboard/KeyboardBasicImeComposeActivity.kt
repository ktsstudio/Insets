package ru.ktsstudio.sample.insets.ui.samples.keyboard

import androidx.compose.runtime.Composable
import ru.ktsstudio.sample.insets.ui.samples.BaseComposeActivity
import ru.ktsstudio.sample.insets.ui.theme.InsetsExamplesTheme
import ru.ktsstudio.sample.insets.utils.setResizeSoftInputMode

class KeyboardBasicImeComposeActivity : BaseComposeActivity() {

    override fun setupOnCreate() {
        window.setResizeSoftInputMode()
    }

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            KeyboardBasicImeSample()
        }
    }
}