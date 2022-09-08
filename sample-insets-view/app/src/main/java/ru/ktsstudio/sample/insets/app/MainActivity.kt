package ru.ktsstudio.sample.insets.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.utils.setDisplayCutoutModeAlways

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setDisplayCutoutModeAlways()
    }
}