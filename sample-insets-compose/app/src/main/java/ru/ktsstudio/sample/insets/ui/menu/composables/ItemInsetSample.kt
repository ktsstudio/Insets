package ru.ktsstudio.sample.insets.ui.menu.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ktsstudio.sample.insets.ui.menu.InsetsSample

@Composable
fun ItemInsetSample(
    item: InsetsSample,
    onItemClick: () -> Unit
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        text = stringResource(item.titleRes)
    )
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    ItemInsetSample(
        item = InsetsSample.BasicList,
        onItemClick = {}
    )
}
