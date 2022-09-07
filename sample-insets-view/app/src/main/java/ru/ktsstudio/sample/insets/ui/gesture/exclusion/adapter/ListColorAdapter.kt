package ru.ktsstudio.sample.insets.ui.gesture.exclusion.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.ktsstudio.sample.insets.ui.gesture.exclusion.adapter.delegates.listItemColorDelegate

fun listColorAdapter() = ListDelegationAdapter(listItemColorDelegate())
