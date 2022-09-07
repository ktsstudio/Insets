package ru.ktsstudio.sample.insets.ui.fullscreen

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentFullscreenStableBinding
import ru.ktsstudio.sample.insets.utils.animateVisibility
import ru.ktsstudio.sample.insets.utils.animateVisibilityHidden
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.hideSystemUi
import ru.ktsstudio.sample.insets.utils.setDisplayCutoutModeAlways
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets
import ru.ktsstudio.sample.insets.utils.showSystemUi

class FullscreenStableFragment : Fragment(R.layout.fragment_fullscreen_stable) {
    private val binding by viewBinding(FragmentFullscreenStableBinding::bind)

    private var isUiVisible: Boolean = true
        set(value) {
            toggleUi(value)
            field = value
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDisplayCutoutModeAlways()
        initToolbar()
        setupInsets()
        binding.root.setOnClickListener {
            isUiVisible = !isUiVisible
        }
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.insets_sample_fullscreen_stable)
        toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupInsets() = with(binding) {
        setupAppBarInsets(
            toolbar = appBar.toolbar,
            useStableInsets = true
        )
    }

    private fun toggleUi(show: Boolean) = with(binding) {
        appBar.toolbar.animateVisibility(show)
        toggleSystemUi(show)
    }

    private fun toggleSystemUi(show: Boolean) {
        with(requireActivity().window) {
            if (show) {
                showSystemUi()
            } else {
                hideSystemUi {
                    systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }
        }
    }
}