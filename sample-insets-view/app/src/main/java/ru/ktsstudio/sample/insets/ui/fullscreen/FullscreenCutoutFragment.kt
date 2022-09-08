package ru.ktsstudio.sample.insets.ui.fullscreen

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ktsstudio.sample.insets.R
import ru.ktsstudio.sample.insets.databinding.FragmentFullscreenCutoutBinding
import ru.ktsstudio.sample.insets.utils.hideSystemUi
import ru.ktsstudio.sample.insets.utils.showSystemUi

// the cutout setting is done in the activity:
// class MainActivity : AppCompatActivity(R.layout.activity_main) {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        window.setDisplayCutoutModeAlways() <-- LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
//    }
//}
class FullscreenCutoutFragment : Fragment(R.layout.fragment_fullscreen_cutout) {

    private val binding by viewBinding(FragmentFullscreenCutoutBinding::bind)

    private var isUiVisible: Boolean = true
        set(value) {
            toggleSystemUi(value)
            field = value
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        root.setOnClickListener {
            isUiVisible = !isUiVisible
        }
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