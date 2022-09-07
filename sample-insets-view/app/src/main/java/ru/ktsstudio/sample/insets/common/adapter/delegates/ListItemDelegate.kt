package ru.ktsstudio.sample.insets.common.adapter.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.ktsstudio.sample.insets.common.data.ListItem
import ru.ktsstudio.sample.insets.databinding.InsetsSampleListItemBinding

fun listItemDelegate() =
    adapterDelegateViewBinding<ListItem.SimpleItem, Any, InsetsSampleListItemBinding>(
        viewBinding = { layoutInflater, root ->
            InsetsSampleListItemBinding.inflate(
                layoutInflater,
                root,
                false
            )
        },
    ) {
        bind {
            val startIcon = getDrawable(item.icon)
            with(binding) {
                titleTextView.text = getString(item.title)

                titleTextView.setCompoundDrawablesWithIntrinsicBounds(
                    startIcon,
                    null,
                    null,
                    null
                )
            }
        }
    }
