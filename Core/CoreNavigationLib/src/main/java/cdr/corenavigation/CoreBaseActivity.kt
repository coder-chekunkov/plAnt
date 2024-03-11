package cdr.corenavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cdr.corelogs.Logger

/**
 * Базовая Activity, которая используется во всех функциональных пакетах системы
 * Реализовывает [AppCompatActivity]
 *
 * @author Alexandr Chekunkov
 */
class CoreBaseActivity : AppCompatActivity() {

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
        private const val TAG = "CoreBaseActivity"
    }
}