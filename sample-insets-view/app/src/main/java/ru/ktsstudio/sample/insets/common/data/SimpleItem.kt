package ru.ktsstudio.sample.insets.common.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.menu.models.InsetsSample

sealed interface ListItem {
    data class SimpleItem(
        @StringRes val title: Int,
        @DrawableRes val icon: Int
    ) : ListItem

    object ListItemInset : ListItem
}

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
    InsetsSample.Fullscreen.Cutout,
    InsetsSample.Fullscreen.Stable,
    InsetsSample.Gesture.Mandatory,
    InsetsSample.Gesture.Exclusion,
)