package ru.ktsstudio.sample.insets.ui.common.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ktsstudio.sample.insets.utils.fractionToElapsedTime
import ru.ktsstudio.sample.insets.utils.toFormattedTime

@Composable
fun SampleMediaPlayer(
    durationSeconds: Long,
    title: String,
    artist: String
) {
    var sliderPosition by rememberSaveable { mutableStateOf(0f) }
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Filled.PlayArrow,
                contentDescription = null
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = artist,
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Column {
                Text(
                    text = durationSeconds.toFormattedTime(),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = sliderPosition
                        .fractionToElapsedTime(durationSeconds)
                        .toFormattedTime(),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
    }
}

@Preview
@Composable
fun SampleMediaPlayerPreview() {
    SampleMediaPlayer(
        durationSeconds = 100L,
        title = "title",
        artist = "artist"
    )
}