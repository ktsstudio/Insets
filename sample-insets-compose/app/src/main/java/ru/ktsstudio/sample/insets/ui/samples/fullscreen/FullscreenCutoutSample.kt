package ru.ktsstudio.sample.insets.ui.samples.fullscreen

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.ktsstudio.sample.insets.ui.common.composables.FullscreenImage

@Composable
fun FullscreenCutoutSample(
    toggleUi: () -> Unit
) {
    Scaffold(
        topBar = {
            Spacer(
                Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
            )
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