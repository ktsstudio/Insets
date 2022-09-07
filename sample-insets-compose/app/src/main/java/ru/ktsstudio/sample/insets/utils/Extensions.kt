package ru.ktsstudio.sample.insets.utils

import android.os.Build
import android.text.format.DateUtils
import android.view.Window
import android.view.WindowManager

fun Long.toFormattedTime(): String {
    return DateUtils.formatElapsedTime(this)
}

fun Float.fractionToElapsedTime(duration: Long): Long {
    return this.times(duration).toLong()
}

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

fun Window.setResizeSoftInputMode() {
    @Suppress("DEPRECATION")
    //or android:windowSoftInputMode="adjustResize" in manifest
    setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
}