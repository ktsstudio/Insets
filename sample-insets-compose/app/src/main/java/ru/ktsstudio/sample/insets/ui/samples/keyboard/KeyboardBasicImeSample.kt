package ru.ktsstudio.sample.insets.ui.samples.keyboard

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun KeyboardBasicImeSample(
    listItems: List<ListItem> = generateRandomListItems()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(
                WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal)
            ),
        topBar = {
            SampleTopBar(
                titleRes = R.string.insets_sample_keyboard_basic
            )
        },
        bottomBar = {
            BottomEditText()
        }
    ) { contentPadding ->
        LazyColumn(
            contentPadding = contentPadding,
            reverseLayout = true
        ) {
            items(listItems) { SampleListItem(it) }
        }
    }
}