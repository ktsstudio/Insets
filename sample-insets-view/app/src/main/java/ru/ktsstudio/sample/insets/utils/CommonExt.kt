package ru.ktsstudio.sample.insets.utils

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.format.DateUtils
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(requireContext(), message, duration).show()

fun Fragment.getDrawable(@DrawableRes drawableRes: Int): Drawable? {
    return ContextCompat.getDrawable(requireContext(), drawableRes)
}

fun View.setSystemGestureExclusionRectsCompat(rects: List<Rect>) {
    ViewCompat.setSystemGestureExclusionRects(this, rects)
}

fun View.removeSystemGestureExclusionRectsCompat() {
    ViewCompat.setSystemGestureExclusionRects(this, listOf())
}

fun SeekBar.addOnProgressChangeListener(onProgressChange: (Int) -> Unit) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            onProgressChange(progress)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
        override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
    })
}

fun Long.toFormattedTime(): String = DateUtils.formatElapsedTime(this)

fun Int.fractionToElapsedTime(duration: Long): Long = this.times(duration)

fun withApi30(action: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        action()
    }
}

fun withApi26(action: () -> Unit): Unit? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        action()
    } else {
        null
    }
}

fun Fragment.setDisplayCutoutModeAlways() {
    requireActivity().window.setDisplayCutoutModeAlways()
}

fun Window.setDisplayCutoutModeAlways() {
    withApi30 {
        attributes.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
    }
}

internal fun View.animateVisibilityHidden(show: Boolean, duration: Long = 200) {
    animate()
        .alpha(if (show) 1f else 0f)
        .withStartAction { if (show) visibility = View.VISIBLE }
        .withEndAction { if (!show) visibility = View.INVISIBLE }
        .setDuration(duration)
        .start()
}


fun View.animateVisibility(show: Boolean) {
    animate()
        .alpha(if (show) 1f else 0f)
        .withStartAction { if (show) isVisible = true }
        .withEndAction { if (!show) isVisible = false }
        .setDuration(200)
        .start()
}
