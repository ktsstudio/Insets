package ru.ktsstudio.sample.insets.ui.keyboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.common.adapter.listAdapter
import ru.ktsstudio.sample.insets.databinding.FragmentKeyboardListSampleBinding
import ru.ktsstudio.sample.insets.utils.applySystemBarsImeInsetter
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.generateRandomListItems
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets

class KeyboardListSampleFragment : Fragment(R.layout.fragment_keyboard_list_sample) {

    private val binding by viewBinding(FragmentKeyboardListSampleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initToolbar()
        setupInsets()
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.insets_sample_keyboard_basic)
        toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupInsets() = with(binding) {
        setupAppBarInsets(appBar.toolbar)
        list.applySystemBarsInsetter {
            padding(horizontal = true)
        }
        messageWrapper.applySystemBarsImeInsetter(syncTranslationView = list) {
            margin(horizontal = true, bottom = true, animated = true)
        }
    }

    private fun initList() {
        val listAdapter = listAdapter()
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        listAdapter.items = generateRandomListItems()

        with(binding.list) {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                stackFromEnd = true
            }
            adapter = listAdapter
            addItemDecoration(divider)
            setHasFixedSize(true)
        }
    }
}