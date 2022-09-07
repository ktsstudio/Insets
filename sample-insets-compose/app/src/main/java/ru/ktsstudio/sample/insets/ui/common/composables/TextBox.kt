package ru.ktsstudio.sample.insets.ui.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ColoredBox(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: Dp = 100.dp,
    color: Color = MaterialTheme.colors.primary,
    border: Dp = (-1).dp // default negative to skip drawing the border
) {
    Box(
        modifier = modifier
            .border(
                width = border,
                color = MaterialTheme.colors.onSurface,
            )
            .size(size)
            .background(
                color = color
            ),
        contentAlignment = Alignment.Center
    ) {
        text?.let {
            Text(
                text = text,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.surface,
                    ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun ColoredBoxPreview() {
    ColoredBox(text = "text")
}