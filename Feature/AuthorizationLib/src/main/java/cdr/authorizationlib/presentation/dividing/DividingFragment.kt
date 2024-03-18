package cdr.authorizationlib.presentation.dividing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import cdr.corecompose.theming.PlAntTheme
import cdr.coreutilslib.utils.viewModelCreator

/**
 * [Fragment] для разводящего экрана
 *
 * @author Alexandr Chekunkov
 */
internal class DividingFragment : Fragment() {

    private val viewModel by viewModelCreator<DividingViewModel> { DividingViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PlAntTheme {
                    DividingContent(viewModel = viewModel)
                }
            }
        }
    }
}