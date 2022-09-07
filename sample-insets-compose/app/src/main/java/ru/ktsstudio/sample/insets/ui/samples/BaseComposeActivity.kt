package ru.ktsstudio.sample.insets.ui.samples

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.ui.common.composables.TransparentSystemBars

abstract class BaseComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Insetsexamples_NoActionBar)
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, because we handle insets ourselves
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setupOnCreate()
        setContent {
            TransparentSystemBars()
            Sample()
        }
    }

    open fun setupOnCreate() {}

    @Composable
    abstract fun Sample()
}