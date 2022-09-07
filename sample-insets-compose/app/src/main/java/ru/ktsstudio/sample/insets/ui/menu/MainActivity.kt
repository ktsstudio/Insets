package ru.ktsstudio.sample.insets.ui.menu

import android.content.Intent
import androidx.compose.runtime.Composable
import ru.ktsstudio.sample.insets.ui.menu.composables.MenuScreen
import ru.ktsstudio.sample.insets.ui.samples.BaseComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.basic_list.ListSampleActivity
import ru.ktsstudio.sample.insets.ui.samples.fullscreen.FullscreenCutoutComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.fullscreen.FullscreenStableComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.gestures.GestureExclusionComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.gestures.MandatoryGestureComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.keyboard.KeyboardBasicImeComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.keyboard.KeyboardScrollImeComposeActivity
import ru.ktsstudio.sample.insets.ui.samples.tappable.TappableSampleActivity
import ru.ktsstudio.sample.insets.ui.theme.InsetsExamplesTheme

class MainActivity : BaseComposeActivity() {

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            MenuScreen(::openInsetsSample)
        }
    }

    private fun openInsetsSample(sample: InsetsSample) {
        val sampleActivity = when (sample) {
            InsetsSample.BasicList -> ListSampleActivity::class
            InsetsSample.Tappable -> TappableSampleActivity::class
            InsetsSample.Fullscreen.Cutout -> FullscreenCutoutComposeActivity::class
            InsetsSample.Fullscreen.Stable -> FullscreenStableComposeActivity::class
            InsetsSample.Gesture.Exclusion -> GestureExclusionComposeActivity::class
            InsetsSample.Gesture.Mandatory -> MandatoryGestureComposeActivity::class
            InsetsSample.Keyboard.BasicIme -> KeyboardBasicImeComposeActivity::class
            InsetsSample.Keyboard.ScrollIme -> KeyboardScrollImeComposeActivity::class
        }
        val intent = Intent(this, sampleActivity.java)
        startActivity(intent)
    }
}

