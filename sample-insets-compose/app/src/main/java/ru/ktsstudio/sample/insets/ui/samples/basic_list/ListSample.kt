package ru.ktsstudio.sample.insets.ui.samples.basic_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.common.composables.SampleListItem
import ru.ktsstudio.sample.insets.ui.common.composables.SampleTopBar
import ru.ktsstudio.sample.insets.ui.common.models.ListItem
import ru.ktsstudio.sample.insets.utils.generateRandomListItems

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListSample(
    listItems: List<ListItem> = generateRandomListItems()
) {
    Scaffold(
        modifier = Modifier.windowInsetsPadding(
            WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal)
        ),
        topBar = {
            SampleTopBar(
                titleRes = R.string.insets_sample_list
            )
        },
        bottomBar = {
            // We add a spacer as a bottom bar, which is the same height as
            // the navigation bar
            Spacer(
                Modifier
                    .windowInsetsBottomHeight(WindowInsets.navigationBars)
                    .fillMaxWidth()
            )
        }
    ) { contentPadding ->
        Box {
            // We apply the contentPadding that accounts for
            // TopBar and BottomBar insets
            // passed to us from the Scaffold
            LazyColumn(
                contentPadding = contentPadding,
                modifier = Modifier.fillMaxSize(),
            ) {
                items(items = listItems) { SampleListItem(it) }
            }
        }
    }
}