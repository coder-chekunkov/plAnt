package cdr.authorizationlib.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cdr.authorizationlib.presentation.authorization.AuthorizationContent
import cdr.authorizationlib.presentation.authorization.AuthorizationViewModel
import cdr.authorizationlib.presentation.dividing.DividingContent
import cdr.authorizationlib.presentation.dividing.DividingViewModel
import cdr.authorizationlib.presentation.registration.RegistrationContent
import cdr.authorizationlib.presentation.registration.RegistrationViewModel
import cdr.corecompose.theming.PlAntTheme

/**
 * Activity для модуля авторизации.
 * Данная Activity состоит из нескольких фрагментов (регистрация, авторизация, разводящий)
 *
 * @author Alexandr Chekunkov
 */
internal class PrimaryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlAntTheme {
//                DividingContent(viewModel = DividingViewModel())
//                AuthorizationContent(viewModel = AuthorizationViewModel())
                RegistrationContent(viewModel = RegistrationViewModel())
            }
        }
    }

    companion object {

        /**
         * Создание [Intent] для запуска [PrimaryActivity]
         */
        fun newIntent(context: Context) = Intent(context, PrimaryActivity::class.java)
    }
}