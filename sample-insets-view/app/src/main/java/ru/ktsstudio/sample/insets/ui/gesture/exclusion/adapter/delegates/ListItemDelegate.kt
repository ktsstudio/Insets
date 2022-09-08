package ru.ktsstudio.sample.insets.ui.gesture.exclusion.adapter.delegates

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.ktsstudio.sample.insets.databinding.ListItemColorBinding
import ru.ktsstudio.sample.insets.ui.gesture.exclusion.models.ColorItem

fun listItemColorDelegate() =
    adapterDelegateViewBinding<ColorItem, ColorItem, ListItemColorBinding>(
        viewBinding = { layoutInflater, root ->
            ListItemColorBinding.inflate(
                layoutInflater,
                root,
                false
            )
        },
    ) {
        bind {
            with(binding) {
                val drawableBackground = root.background
                drawableBackground.colorFilter = PorterDuffColorFilter(
                    item.color,
                    PorterDuff.Mode.MULTIPLY
                )
                root.background = drawableBackground
            }
        }
    }
