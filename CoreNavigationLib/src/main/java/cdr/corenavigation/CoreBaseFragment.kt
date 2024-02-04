package cdr.corenavigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import cdr.corelogs.Logger

/**
 * Базовый Fragment, который используется во всех функциональных пакетах системы
 * Реализовывает [Fragment]
 *
 * @author Alexandr Chekunkov
 */
class CoreBaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.i(tag = TAG, message = "${javaClass.name} was onCreate.")
    }

    override fun onStart() {
        super.onStart()
        Logger.i(tag = TAG, message = "${javaClass.name} was onStart.")
    }

    override fun onResume() {
        super.onResume()
        Logger.i(tag = TAG, message = "${javaClass.name} was onResume.")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.i(tag = TAG, message = "${javaClass.name} was onAttach.")
    }

    override fun onDetach() {
        super.onDetach()
        Logger.i(tag = TAG, message = "${javaClass.name} was onDetach.")
    }

    override fun onPause() {
        super.onPause()
        Logger.i(tag = TAG, message = "${javaClass.name} was onPause.")
    }

    override fun onStop() {
        super.onStop()
        Logger.i(tag = TAG, message = "${javaClass.name} was onStop.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.i(tag = TAG, message = "${javaClass.name} was onDestroy.")
    }

    companion object {
        private const val TAG = "CoreBaseFragment"
    }
}