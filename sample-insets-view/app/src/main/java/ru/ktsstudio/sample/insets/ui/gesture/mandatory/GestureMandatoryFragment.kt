package ru.ktsstudio.sample.insets.ui.gesture.mandatory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentGestureMandatoryBinding
import ru.ktsstudio.sample.insets.utils.addOnProgressChangeListener
import ru.ktsstudio.sample.insets.utils.applyMandatoryGesturesInsetter
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.fractionToElapsedTime
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets
import ru.ktsstudio.sample.insets.utils.toFormattedTime

class GestureMandatoryFragment : Fragment(R.layout.fragment_gesture_mandatory) {

    private val binding by viewBinding(FragmentGestureMandatoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initContent()
        initToolbar()
        setupInsets()
        setupListeners()
    }

    private fun initContent() = with(binding) {
        totalTime.text = DURATION_SECONDS.toFormattedTime()
        seekBar.max = MAX_PROGRESS
    }

    private fun setupListeners() = with(binding) {
        seekBar.addOnProgressChangeListener { progress ->
            progressTime.text = progress.fractionToElapsedTime(DURATION_SECONDS).toFormattedTime()
        }
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.insets_sample_gesture_mandatory)
        toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupInsets() = with(binding) {
        setupAppBarInsets(appBar.toolbar)
        mediaGroup.applySystemBarsInsetter {
            padding(horizontal = true)
        }
        seekBar.applyMandatoryGesturesInsetter {
            padding(bottom = true)
        }
    }

    companion object {
        private const val DURATION_SECONDS = 600L
        private const val MAX_PROGRESS = 60
    }
}