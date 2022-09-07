package ru.ktsstudio.sample.insets.ui.gesture.exclusion

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentGestureExclusionBinding
import ru.ktsstudio.sample.insets.ui.gesture.exclusion.adapter.listColorAdapter
import ru.ktsstudio.sample.insets.utils.applySystemBarsInsetter
import ru.ktsstudio.sample.insets.utils.generateRandomColorItems
import ru.ktsstudio.sample.insets.utils.getDrawable
import ru.ktsstudio.sample.insets.utils.removeSystemGestureExclusionRectsCompat
import ru.ktsstudio.sample.insets.utils.setSystemGestureExclusionRectsCompat
import ru.ktsstudio.sample.insets.utils.setupAppBarInsets

class GestureExclusionFragment : Fragment(R.layout.fragment_gesture_exclusion) {

    private val binding by viewBinding(FragmentGestureExclusionBinding::bind)

    private var bottomSheetCallback: BottomSheetBehavior.BottomSheetCallback? = null

    private var _bottomSheetBehavior: BottomSheetBehavior<LinearLayoutCompat>? = null
    private val bottomSheetBehavior: BottomSheetBehavior<LinearLayoutCompat>
        get() = _bottomSheetBehavior!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomSheetBehavior()
        initToolbar()
        setupInsets()
    }

    private fun initBottomSheetBehavior() = with(binding) {
        _bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetInclude.root)
        initHorizontalList()
    }

    private fun initToolbar() = with(binding.appBar) {
        toolbar.setTitle(R.string.insets_sample_gesture_exclusion)
        toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupInsets() = with(binding) {
        setupAppBarInsets(appBar.toolbar)
        bottomSheetInclude.root.applySystemBarsInsetter {
            padding(horizontal = true, bottom = true)
        }

        ViewCompat.setOnApplyWindowInsetsListener(root) { _, windowInsets ->
            setupBottomSheetCollback(bottomSheetBehavior, windowInsets)
            windowInsets
        }
    }

    private fun initHorizontalList() {
        val listAdapter = listColorAdapter()
        listAdapter.items = generateRandomColorItems()

        with(binding.bottomSheetInclude.list) {
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }

    private fun <T : View> setupBottomSheetCollback(
        bottomSheetBehavior: BottomSheetBehavior<T>,
        windowInsets: WindowInsetsCompat
    ) {
        bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) = Unit

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        excludeGesturesHorizontalLit(windowInsets)
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        binding.root.removeSystemGestureExclusionRectsCompat()
                    }
                }
            }
        }
        bottomSheetCallback?.let(bottomSheetBehavior::addBottomSheetCallback)
    }

    private fun excludeGesturesHorizontalLit(windowInsets: WindowInsetsCompat) {
        binding.root.doOnLayout {
            val gestureInsets =
                windowInsets.getInsets(WindowInsetsCompat.Type.systemGestures())

            with(binding) {
                val rectTop = root.bottom - bottomSheetInclude.list.height
                val rectBottom = root.bottom

                val leftExclusionRectLeft = 0
                val leftExclusionRectRight = gestureInsets.left

                val rightExclusionRectLeft = root.right - gestureInsets.right
                val rightExclusionRectRight = root.right

                val exclusionRects = listOf(
                    Rect(
                        leftExclusionRectLeft,
                        rectTop,
                        leftExclusionRectRight,
                        rectBottom
                    ),
                    Rect(
                        rightExclusionRectLeft,
                        rectTop,
                        rightExclusionRectRight,
                        rectBottom
                    )
                )

                root.setSystemGestureExclusionRectsCompat(rects = exclusionRects)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bottomSheetCallback?.let {
            bottomSheetBehavior.removeBottomSheetCallback(it)
        }
        bottomSheetCallback = null
        _bottomSheetBehavior = null
    }
}