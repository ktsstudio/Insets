package ru.ktsstudio.sample.insets.ui.basiclist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.common.adapter.listAdapter
import ru.ktsstudio.sample.insets.common.data.ListItem
import ru.ktsstudio.sample.insets.databinding.FragmentListSampleBinding
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.generateRandomListItems
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets

class ListSampleFragment : Fragment(R.layout.fragment_list_sample) {

    private val binding by viewBinding(FragmentListSampleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initToolbar()
        setupInsets()
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.insets_sample_list)
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
    }

    private fun initList() {
        val listAdapter = listAdapter()
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        listAdapter.setDataWithInset(generateRandomListItems())
        with(binding.list) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
            addItemDecoration(divider)
            setHasFixedSize(true)
        }
    }

    private fun ListDelegationAdapter<List<Any>>.setDataWithInset(data: List<Any>) {
        items = data + listOf(ListItem.ListItemInset)
    }
}