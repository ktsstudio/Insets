package ru.ktsstudio.sample.insets.ui.tappable

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentTappableBinding
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.applyTappableInsetter
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets

class TappableFragment : Fragment(R.layout.fragment_tappable) {

    private val binding by viewBinding(FragmentTappableBinding::bind)

    private val viewModel by viewModels<TappableViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        setupInsets()
        setupViewModel()
        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        fab.setOnClickListener {
            viewModel.changeVisibleState()
        }
    }

    private fun setupViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.visibleState.collect(::renderState)
            }
        }
    }

    private fun renderState(show: Boolean) = with(binding) {
        image.isVisible = show

        val fabImage = if (show) R.drawable.ic_visibility_off else R.drawable.ic_visibility
        fab.setImageResource(fabImage)
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.insets_sample_tappable)
        toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupInsets() = with(binding) {
        setupAppBarInsets(appBar.toolbar)
        fab.applyTappableInsetter {
            margin(bottom = true, horizontal = true)
        }
    }
}