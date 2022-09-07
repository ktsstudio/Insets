package ru.ktsstudio.sample.insets.utils

import android.graphics.Paint
import ru.ktsstudio.sample.insets.common.data.ListItem
import ru.ktsstudio.sample.insets.common.data.insetsSamples
import ru.ktsstudio.sample.insets.common.data.sampleIcons
import ru.ktsstudio.sample.insets.ui.gesture.exclusion.models.ColorItem
import kotlin.random.Random

fun <T> generateList(count: Int, generator: () -> T): List<T> = List(count) { generator() }

fun generateRandomListItems(count: Int = 50): List<ListItem.SimpleItem> = generateList(count) { randomListItem() }

fun generateRandomColorItems(count: Int = 50): List<ColorItem> = generateList(count) { randomListColor() }

fun randomListItem(): ListItem.SimpleItem {
    val title = insetsSamples.random()
    val icon = sampleIcons.random()
    return ListItem.SimpleItem(title.titleRes, icon)
}

fun randomListColor(): ColorItem = ColorItem(color = randomColorInt())

fun randomColorInt(): Int {
    return Paint().apply {
        setARGB(
            255,
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }.color
}