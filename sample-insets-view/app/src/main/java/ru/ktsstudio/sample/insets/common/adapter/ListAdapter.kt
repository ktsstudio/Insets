package ru.ktsstudio.sample.insets.common.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.ktsstudio.sample.insets.common.adapter.delegates.listItemDelegate
import ru.ktsstudio.sample.insets.common.adapter.delegates.listItemInsetDelegate

fun listAdapter() = ListDelegationAdapter(
    listItemDelegate(),
    listItemInsetDelegate()
)
