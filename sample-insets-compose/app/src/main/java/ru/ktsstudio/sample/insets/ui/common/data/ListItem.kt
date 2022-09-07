package ru.ktsstudio.sample.insets.ui.common.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.menu.InsetsSample

val sampleTitles = listOf(
    "System Window Insets",
    "Stable Insets",
    "Display Cutout",
    "Gesture Insets",
    "Mandatory Gesture Insets",
    "IME Insets",
)

val sampleIcons = listOf(
    R.drawable.ic_favorite,
    R.drawable.ic_rocket,
    R.drawable.ic_smile,
    R.drawable.ic_pets,
    R.drawable.ic_star
)

val insetsSamples = listOf(
    InsetsSample.BasicList,
    InsetsSample.Tappable,
    InsetsSample.Keyboard.BasicIme,
    InsetsSample.Keyboard.ScrollIme,
    InsetsSample.Fullscreen.Cutout,
    InsetsSample.Fullscreen.Stable,
    InsetsSample.Gesture.Mandatory,
    InsetsSample.Gesture.Exclusion,
)