package logger

import kotlinx.coroutines.runBlocking


interface LoggerInterface {
    fun log(message: LogModel)
}


class ConsoleLogger : LoggerInterface {
    override fun log(message: LogModel) {
        println("printing on console $message")
    }
}

class FileLogger : LoggerInterface {
    override fun log(message: LogModel) {
        println("printing on file $message")
    }
}

data class LogModel(
    val message: String,
    val tag: String,
    val severity: Severity,
    val timeStamp: Long = System.currentTimeMillis(),
)


object Logger {

    val loggers: ArrayList<LoggerInterface> = arrayListOf()

    fun addLogger(logger: LoggerInterface) {
        loggers.add(logger)
    }

    fun removeLogger(logger: LoggerInterface) {
        loggers.remove(logger)
    }

    fun log(severity: Severity, tag: String, message: String) {
        val model = LogModel(
            tag = tag, message = message, severity = severity
        )
        loggers.forEach {
            it.log(model)
        }
    }


    fun d(tag: String, message: () -> String) {
        log(Severity.DEBUG, tag, message())
    }
}


enum class Severity {
    INFO, DEBUG, ERROR
}


fun main() {
    Logger.addLogger(FileLogger())
    Logger.d(
        tag = "HP",
        message = { expensive() },
    )
}

fun expensive() : String = runBlocking{
    Thread.sleep(1000)
    "expensive op"
}