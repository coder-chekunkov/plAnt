package cdr.coreutilslib.utils

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

typealias ViewModelCreator = () -> ViewModel?

/**
 * Фабрика для создания [ViewModel]
 *
 * @author Alexandr Chekunkov
 */
class ViewModelFactory(private val creator: ViewModelCreator) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return creator() as T
    }
}

/**
 * Создание [ViewModel] в [ComponentActivity].
 *
 * @author Alexandr Chekunkov
 */
inline fun <reified VM : ViewModel> ComponentActivity.viewModelCreator(noinline creator: ViewModelCreator): Lazy<VM> {
    return viewModels { ViewModelFactory(creator) }
}

/**
 * Создание [ViewModel] в [Fragment].
 *
 *  @author Alexandr Chekunkov
 */
inline fun <reified VM : ViewModel> Fragment.viewModelCreator(noinline creator: ViewModelCreator): Lazy<VM> {
    return viewModels { ViewModelFactory(creator) }
}