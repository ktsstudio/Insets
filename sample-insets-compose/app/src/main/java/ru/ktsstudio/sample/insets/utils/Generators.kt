package ru.ktsstudio.sample.insets.utils

import androidx.compose.ui.graphics.Color
import ru.ktsstudio.sample.insets.ui.common.models.ListItem
import ru.ktsstudio.sample.insets.ui.common.data.sampleIcons
import ru.ktsstudio.sample.insets.ui.common.data.sampleTitles
import kotlin.random.Random

fun <T> generateList(count: Int, generator: () -> T): List<T> {
    return List(count) { generator() }
}

fun randomListItem(): ListItem {
    val title = sampleTitles.random()
    val icon = sampleIcons.random()
    return ListItem(title, icon)
}

fun generateRandomListItems(count: Int = 50): List<ListItem> {
    return generateList(count) {
        randomListItem()
    }
}

fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat()
    )
}