package ru.ktsstudio.sample.insets.ui.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetIndicator() {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
                shape = RoundedCornerShape(50),
            )
            .size(width = 36.dp, height = 4.dp)
    )
}

@Preview
@Composable
fun BottomSheetIndicatorPreview() {
    BottomSheetIndicator()
}