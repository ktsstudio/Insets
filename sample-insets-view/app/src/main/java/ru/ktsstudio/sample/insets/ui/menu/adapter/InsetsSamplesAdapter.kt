package ru.ktsstudio.sample.insets.ui.menu.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.ktsstudio.sample.insets.ui.menu.adapter.delegates.insetsSampleItemDelegate
import ru.ktsstudio.sample.insets.ui.menu.models.InsetsSample

fun insetsSamplesAdapter(onItemClick: (InsetsSample) -> Unit) =
    ListDelegationAdapter(
        insetsSampleItemDelegate(onItemClick)
    )
