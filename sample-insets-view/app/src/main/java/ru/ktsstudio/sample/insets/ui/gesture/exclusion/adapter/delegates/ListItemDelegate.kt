package ru.ktsstudio.sample.insets.ui.gesture.exclusion.adapter.delegates

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toDrawable
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.ktsstudio.sample.insets.databinding.ListItemColorBinding
import ru.ktsstudio.sample.insets.ui.gesture.exclusion.models.ColorItem
import ru.ktsstudio.sample.insets.utils.withApi26

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
