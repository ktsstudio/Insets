package ru.ktsstudio.sample.insets.utils

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.ktsstudio.sample.insets.common.data.ListItem

fun ListDelegationAdapter<List<Any>>.setDataWithInset(data: List<Any>) {
    items = data + listOf(ListItem.ListItemInset)
}
