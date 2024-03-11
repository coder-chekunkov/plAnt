package cdr.corelogs

/**
 * Объект логирования, который используется в системе
 *
 * @author Alexandr Chekunkov
 */
object Logger {

    private val logDetails: LogDetails = LogDetailsImpl()

    @JvmStatic
    fun e(tag: String, message: String, throwable: Throwable) = logDetails.e(tag, message, throwable)

    @JvmStatic
    fun i(tag: String, message: String) = logDetails.i(tag, message)

    @JvmStatic
    fun d(tag: String, message: String) = logDetails.d(tag, message)
}