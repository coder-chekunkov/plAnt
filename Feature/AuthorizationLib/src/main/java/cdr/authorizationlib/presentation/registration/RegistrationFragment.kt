package cdr.authorizationlib.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import cdr.corecompose.theming.PlAntTheme
import cdr.coreutilslib.utils.viewModelCreator

/**
 * [Fragment] для экрана регистрации
 *
 * @author Alexandr Chekunkov
 */
internal class RegistrationFragment : Fragment() {

    private val viewModel by viewModelCreator<RegistrationViewModel> { RegistrationViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PlAntTheme {
                    RegistrationContent(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}