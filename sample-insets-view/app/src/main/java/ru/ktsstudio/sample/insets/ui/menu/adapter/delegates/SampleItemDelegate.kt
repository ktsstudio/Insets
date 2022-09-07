package ru.ktsstudio.sample.insets.ui.menu.adapter.delegates

import android.util.Log
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.ktsstudio.sample.insets.databinding.InsetsSampleListItemBinding
import ru.ktsstudio.sample.insets.ui.menu.models.InsetsSample

fun insetsSampleItemDelegate(onItemClick: (InsetsSample) -> Unit) =
    adapterDelegateViewBinding<InsetsSample, InsetsSample, InsetsSampleListItemBinding>(
        viewBinding = { layoutInflater, root ->
            InsetsSampleListItemBinding.inflate(
                layoutInflater,
                root,
                false
            )
        },
    ) {
        binding.root.setOnClickListener {
            onItemClick(item)
        }
        bind {
            binding.titleTextView.text = getString(item.titleRes)
        }
    }
