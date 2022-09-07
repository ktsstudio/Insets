package ru.ktsstudio.sample.insets.ui.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.ktsstudio.sample.insets.ui.common.models.ListItem

@ExperimentalMaterialApi
@Composable
fun SampleListItem(listItem: ListItem) {
    ListItem(
        icon = {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(listItem.icon),
                contentDescription = null
            )
        },
        text = { Text(listItem.title) },
        modifier = Modifier.fillMaxWidth()
    )
}