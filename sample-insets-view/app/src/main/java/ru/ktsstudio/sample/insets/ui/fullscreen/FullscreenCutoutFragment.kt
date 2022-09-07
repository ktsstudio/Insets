package ru.ktsstudio.sample.insets.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentFullscreenCutoutBinding
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.hideSystemUi
import ru.ktsstudio.sample.insets.utils.setDisplayCutoutModeAlways
import ru.ktsstudio.sample.insets.utils.showSystemUi

class FullscreenCutoutFragment : Fragment(R.layout.fragment_fullscreen_cutout) {

    private val binding by viewBinding(FragmentFullscreenCutoutBinding::bind)

    private var isUiVisible: Boolean = true
        set(value) {
            toggleUi(value)
            field = value
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDisplayCutoutModeAlways()
        binding.root.setOnClickListener {
            isUiVisible = !isUiVisible
        }
    }

    private fun toggleUi(show: Boolean) = with(binding) {
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