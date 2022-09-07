package ru.ktsstudio.sample.insets.ui.common.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class ListItem(
    val title: String,
    @DrawableRes val icon: Int
)