package ru.ktsstudio.sample.insets.ui.samples.tappable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.tappableElement
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.LayoutDirection
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.common.composables.SampleListItem
import ru.ktsstudio.sample.insets.ui.common.composables.SampleTopBar
import ru.ktsstudio.sample.insets.ui.common.models.ListItem
import ru.ktsstudio.sample.insets.ui.samples.BaseComposeActivity
import ru.ktsstudio.sample.insets.ui.theme.InsetsExamplesTheme
import ru.ktsstudio.sample.insets.utils.navigationBarsInset
import ru.ktsstudio.sample.insets.utils.randomListItem

@OptIn(ExperimentalMaterialApi::class)
class TappableSampleActivity : BaseComposeActivity() {

    @Composable
    override fun Sample() {
        var list by rememberSaveable { mutableStateOf(listOf<ListItem>()) }

        InsetsExamplesTheme {
            Scaffold(
                modifier = Modifier.windowInsetsPadding(
                    WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal)
                ),
                topBar = {
                    SampleTopBar(
                        titleRes = R.string.insets_sample_tappable
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        modifier = Modifier.padding(
                            bottom = WindowInsets.tappableElement
                                .only(WindowInsetsSides.Bottom)
                                .asPaddingValues()
                                .calculateBottomPadding()
                        ),
                        backgroundColor = MaterialTheme.colors.primary,
                        onClick = { list = list + randomListItem() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null
                        )
                    }
                }
            ) { contentPadding ->
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = contentPadding.calculateTopPadding(),
                        start = contentPadding.calculateStartPadding(LayoutDirection.Ltr),
                        end = contentPadding.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = contentPadding.calculateBottomPadding()
                            .plus(navigationBarsInset.calculateBottomPadding())
                    )
                ) {
                    items(list) {
                        SampleListItem(it)
                    }
                }
            }
        }
    }
}