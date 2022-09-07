package ru.ktsstudio.sample.insets.ui.tappable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentTappableBinding
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.applyTappableInsetter
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets

class TappableFragment : Fragment(R.layout.fragment_tappable) {

    private val binding by viewBinding(FragmentTappableBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        setupInsets()
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

        fab.applySystemBarsInsetter {
            margin(horizontal = true)
        }
        fab.applyTappableInsetter {
            margin(bottom = true)
        }

        fabCenter.applySystemBarsInsetter {
            margin(horizontal = true, bottom = true)
        }
    }
}