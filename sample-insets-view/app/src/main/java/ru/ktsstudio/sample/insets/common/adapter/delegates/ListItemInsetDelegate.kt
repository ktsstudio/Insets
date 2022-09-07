package ru.ktsstudio.sample.insets.common.adapter.delegates

import android.graphics.Color
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.ktsstudio.sample.insets.common.data.ListItem
import ru.ktsstudio.sample.insets.databinding.ListItemInsetBinding
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter

fun listItemInsetDelegate() =
    adapterDelegateViewBinding<ListItem.ListItemInset, Any, ListItemInsetBinding>(
        viewBinding = { layoutInflater, root ->
            ListItemInsetBinding.inflate(
                layoutInflater,
                root,
                false
            )
        },
    ) {
        bind {
            binding.root.setBackgroundColor(Color.BLACK)
            binding.root.applySystemBarsInsetter {
                margin(bottom = true)
            }
        }
    }