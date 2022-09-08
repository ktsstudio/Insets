package ru.ktsstudio.sample.insets.utils

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.format.DateUtils
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.SeekBar
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

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

fun Window.setDisplayCutoutModeAlways() {
    withApi30 {
        attributes.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
    }
}

fun View.animateVisibility(show: Boolean) {
    animate()
        .alpha(if (show) 1f else 0f)
        .withStartAction { if (show) isVisible = true }
        .withEndAction { if (!show) isVisible = false }
        .setDuration(200)
        .start()
}
