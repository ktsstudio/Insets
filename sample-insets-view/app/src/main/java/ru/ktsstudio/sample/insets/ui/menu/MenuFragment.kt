package ru.ktsstudio.sample.insets.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.common.data.insetsSamples
import ru.ktsstudio.sample.insets.databinding.FragmentMenuBinding
import ru.ktsstudio.sample.insets.ui.menu.adapter.insetsSamplesAdapter
import ru.ktsstudio.sample.insets.ui.menu.models.InsetsSample
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding by viewBinding(FragmentMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initToolbar()
        setupInsets()
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.menu_title)
    }

    private fun setupInsets() = with(binding) {
        setupAppBarInsets(appBar.toolbar)
        list.applySystemBarsInsetter {
            padding(horizontal = true, bottom = true)
        }
    }

    private fun initList() {
        val insetsSamplesAdapter = insetsSamplesAdapter(::openInsetsSample)
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        insetsSamplesAdapter.items = insetsSamples
        with(binding.list) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = insetsSamplesAdapter
            addItemDecoration(divider)
            setHasFixedSize(true)
        }
    }

    private fun openInsetsSample(sample: InsetsSample) {
        val action = when (sample) {
            InsetsSample.BasicList -> MenuFragmentDirections.actionMenuFragmentToListSampleFragment()
            InsetsSample.Tappable -> MenuFragmentDirections.actionMenuFragmentToTappableFragment()
            InsetsSample.Keyboard.BasicIme -> MenuFragmentDirections.actionMenuFragmentToKeyboardListSampleFragment()
            InsetsSample.Gesture.Exclusion -> MenuFragmentDirections.actionMenuFragmentToGestureExclusionFragment()
            InsetsSample.Gesture.Mandatory -> MenuFragmentDirections.actionMenuFragmentToGestureMandatoryFragment()
            InsetsSample.Fullscreen.Cutout -> MenuFragmentDirections.actionMenuFragmentToFullscreenCutoutFragment()
            InsetsSample.Fullscreen.Stable -> MenuFragmentDirections.actionMenuFragmentToFullscreenStableFragment()
            else -> error("Not implementation") // todo remove
//            InsetsSample.Keyboard.BasicIme -> KeyboardBasicImeComposeActivity::class
//            InsetsSample.Keyboard.ScrollIme -> KeyboardScrollImeComposeActivity::class
        }
        findNavController().navigate(action)
    }
}