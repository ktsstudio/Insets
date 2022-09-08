package ru.ktsstudio.sample.insets.ui.samples.gestures

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.systemGestureExclusion
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.common.composables.BottomSheetIndicator
import ru.ktsstudio.sample.insets.ui.common.composables.BottomSheetInsetScaffold
import ru.ktsstudio.sample.insets.ui.common.composables.ColoredBox
import ru.ktsstudio.sample.insets.ui.common.composables.SampleTopBar
import ru.ktsstudio.sample.insets.utils.generateList
import ru.ktsstudio.sample.insets.utils.randomColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GestureExclusionSample(
    colorsList: List<Color> = generateList(50) {
        randomColor()
    }
) {
    BottomSheetInsetScaffold(
        topBar = {
            SampleTopBar(
                titleRes = R.string.insets_sample_gesture_exclusion
            )
        },
        sheetContent = { height ->
            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                ) {
                    BottomSheetIndicator()
                }
                Spacer(
                    modifier = Modifier
                        .size(32.dp)
                )
                LazyRow(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .systemGestureExclusion(),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val gestureInclusiveSize = 200.dp
                    val extraAreaSize = 32.dp
                    item {
                        MatchParentWidthColumn {
                            ColoredBox(
                                modifier = Modifier.fillMaxWidth(),
                                size = extraAreaSize,
                                color = MaterialTheme.colors.surface,
                                border = 2.dp,
                                text = """
                                    Extra 32dp
                                """.trimIndent()
                            )
                            ColoredBox(
                                size = gestureInclusiveSize,
                                color = MaterialTheme.colors.surface,
                                border = 2.dp,
                                text = """
                                    200dp
                                    Gestures doesn't work here
                                    But works in the upper area
                                """.trimIndent()
                            )
                        }
                    }
                    items(items = colorsList) { color ->
                        MatchParentWidthColumn {
                            ColoredBox(
                                modifier = Modifier.fillMaxWidth(),
                                size = extraAreaSize,
                                color = MaterialTheme.colors.error
                            )
                            ColoredBox(
                                size = gestureInclusiveSize,
                                color = color
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = MaterialTheme.colors.secondaryVariant
        ) {}
    }
}

@Preview
@Composable
fun GestureExclusionSamplePreview() {
    GestureExclusionSample()
}

@Composable
private fun MatchParentWidthColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        Modifier.width(IntrinsicSize.Max),
        content = content
    )
}
