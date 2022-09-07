package ru.ktsstudio.sample.insets.ui.common.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import ru.ktsstudio.sample.insets.R

@Composable
fun FullscreenImage(
    @DrawableRes drawableRes: Int = R.drawable.ic_sample_image,
    scale: ContentScale = ContentScale.Crop,
    onClick: (() -> Unit),
    interactionSource: MutableInteractionSource
) {
    Image(
        painter = rememberAsyncImagePainter(
            model = drawableRes,
            contentScale = scale
        ),
        contentDescription = null,
        contentScale = scale,
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() },
            )
    )
}