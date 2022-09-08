package ru.ktsstudio.sample.insets.utils

import android.view.View
import androidx.appcompat.widget.Toolbar
import dev.chrisbanes.insetter.InsetterApplyTypeDsl
import dev.chrisbanes.insetter.applyInsetter

fun setupAppBarInsets(toolbar: Toolbar, useStableInsets: Boolean = false) {
    toolbar.applySystemBarsInsetter(
        useStableInsets = useStableInsets
    ) {
        padding(horizontal = true)
        margin(top = true)
    }
}

inline fun View.applySystemBarsInsetter(
    useStableInsets: Boolean = false,
    crossinline insetterApply: InsetterApplyTypeDsl.() -> Unit
) {
    applyInsetter {
        type(navigationBars = true, statusBars = true, displayCutout = true) {
            insetterApply()
        }
        ignoreVisibility(useStableInsets)
    }
}

inline fun View.applySystemBarsImeInsetter(
    syncTranslationView: View? = null,
    crossinline insetterApply: InsetterApplyTypeDsl.() -> Unit
) {
    applyInsetter {
        type(ime = true, navigationBars = true, statusBars = true) {
            insetterApply()
        }
        syncTranslationView?.let {
            syncTranslationTo(it)
        }
    }
}

inline fun View.applyMandatoryGesturesInsetter(
    crossinline insetterApply: InsetterApplyTypeDsl.() -> Unit
) {
    applyInsetter {
        type(mandatorySystemGestures = true) {
            insetterApply()
        }
    }
}

inline fun View.applyTappableInsetter(
    crossinline insetterApply: InsetterApplyTypeDsl.() -> Unit
) {
    applyInsetter {
        type(tappableElement = true) {
            insetterApply()
        }
    }
}
