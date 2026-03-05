package exceptions

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyException(message: String) : Exception(message)


fun main(): Unit = runBlocking {
    val a = 10
    val b = 0

    val handler = CoroutineExceptionHandler {
        context, exception ->
        println("Caught $exception")
    }

    try {
        val threadName = Thread.currentThread().name
        GlobalScope.launch(Dispatchers.IO + handler){
            println(a / b)
            println(threadName)
        }.join()
    } catch (e: Exception) {
       val exception = e is ArithmeticException
        println("Caught ArithmeticException $exception with message ${e.message}")
    }
}