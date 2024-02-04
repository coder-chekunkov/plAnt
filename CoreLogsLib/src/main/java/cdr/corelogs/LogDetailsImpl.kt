package cdr.corelogs

import android.util.Log

/**
 * Реализация [LogDetails]
 *
 * @author Alexandr Chekunkov
 */
internal class LogDetailsImpl : LogDetails {

    override fun e(tag: String, message: String, throwable: Throwable){
        Log.e(tag, message, throwable)
    }

    override fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}