package cdr.corelogs

/**
 * Доступные уровни логгирования
 *
 * @author Alexandr Chekunkov
 */
interface LogDetails {

    /** уровень логирования - "ошибка" */
    fun e(tag: String, message: String, throwable: Throwable)

    /** уровень логирования - "информация" */
    fun i(tag: String, message: String)

    /** уровень логирвоания - "отладка" */
    fun d(tag: String, message: String)
}