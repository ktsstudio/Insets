package ru.ktsstudio.sample.insets.ui.samples.fullscreen

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.ktsstudio.sample.insets.ui.common.composables.FullscreenImage
import ru.ktsstudio.sample.insets.ui.common.composables.SampleTopBar

import kotlinx.coroutines.flow.StateFlow
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.utils.StableStatusBarsInsetsHolder

@Composable
fun FullscreenStableSample(
    toggleUi: () -> Unit,
    isSystemUiVisible: StateFlow<Boolean>
) {
    val stableInsetsHolder = remember { StableStatusBarsInsetsHolder() }
    val systemUiVisibleState = isSystemUiVisible.collectAsState()

    Scaffold(
        topBar = {
            if (systemUiVisibleState.value) {
                SampleTopBar(
                    titleRes = R.string.insets_sample_fullscreen_stable,
                    contentPadding = stableInsetsHolder.stableStatusBars
                        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                        .asPaddingValues(),
                )
            }
        },
        bottomBar = {
            Spacer(
                Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth()
            )
        }
    ) { contentPadding ->
        val interactionSource = remember { MutableInteractionSource() }
        Column(
            Modifier.padding(contentPadding)
        ) {
            FullscreenImage(
                interactionSource = interactionSource,
                onClick = toggleUi
            )
        }
    }
}