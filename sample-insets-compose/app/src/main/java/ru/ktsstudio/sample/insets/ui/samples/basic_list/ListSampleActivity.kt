package ru.ktsstudio.sample.insets.ui.samples.basic_list

import androidx.compose.runtime.Composable
import ru.ktsstudio.sample.insets.ui.samples.BaseComposeActivity
import ru.ktsstudio.sample.insets.ui.theme.InsetsExamplesTheme

class ListSampleActivity : BaseComposeActivity() {

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            ListSample()
        }
    }
}