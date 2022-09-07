package ru.ktsstudio.sample.insets.ui.menu.models

import androidx.annotation.StringRes
import ru.ktsstudio.sample.insets.R

sealed class InsetsSample(
    @StringRes open val titleRes: Int
) {
    sealed class Fullscreen(@StringRes override val titleRes: Int) : InsetsSample(titleRes) {
        object Stable : Fullscreen(R.string.insets_sample_fullscreen_stable)
        object Cutout : Fullscreen(R.string.insets_sample_fullscreen_cutout)
    }

    sealed class Gesture(@StringRes override val titleRes: Int) : InsetsSample(titleRes) {
        object Mandatory : Gesture(R.string.insets_sample_gesture_mandatory)
        object Exclusion : Gesture(R.string.insets_sample_gesture_exclusion)
    }

    sealed class Keyboard(@StringRes override val titleRes: Int) : InsetsSample(titleRes) {
        object BasicIme : Keyboard(R.string.insets_sample_keyboard_basic)
    }

    object Tappable : InsetsSample(R.string.insets_sample_tappable)

    object BasicList : InsetsSample(R.string.insets_sample_list)
}