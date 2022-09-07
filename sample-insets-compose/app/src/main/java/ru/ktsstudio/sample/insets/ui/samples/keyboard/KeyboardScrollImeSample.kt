package ru.ktsstudio.sample.insets.ui.samples.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.tappableElement
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.common.composables.BottomEditText
import ru.ktsstudio.sample.insets.ui.common.composables.SampleListItem
import ru.ktsstudio.sample.insets.ui.common.composables.SampleTopBar
import ru.ktsstudio.sample.insets.ui.common.models.ListItem
import ru.ktsstudio.sample.insets.utils.generateRandomListItems

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun KeyboardScrollImeSample(
    listItems: List<ListItem> = generateRandomListItems()
) {
    Scaffold(
        modifier = Modifier
            .windowInsetsPadding(
                WindowInsets.navigationBars
                    .only(WindowInsetsSides.Horizontal)
                    .union(WindowInsets.tappableElement)
            ),
        topBar = {
            SampleTopBar(
                titleRes = R.string.insets_sample_keyboard_scroll
            )
        },
        bottomBar = {
            BottomEditText()
        }
    ) { contentPadding ->
        Column {
            LazyColumn(
                contentPadding = contentPadding,
                reverseLayout = true,
                modifier = Modifier
                    .weight(1f)
                    .imeNestedScroll()
            ) {
                items(listItems) { SampleListItem(it) }
            }
        }
    }
}