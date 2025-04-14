package coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun doLongRunningTaskOne(): Int {
    delay(2400)
    println("Task one is getting executed")
    return 33
}

suspend fun doLongRunningTaskTwo(): Int {
    delay(1500)
    println("Task two is getting executed")
    return 6
}


fun main(): Unit = runBlocking{

//    coroutineScope {
//        val one = async {  doLongRunningTaskOne() }
//        val two = async {  doLongRunningTaskTwo() }
//
//        println("Fired both tasks")
//        one.start()
//
//        val res1 = one.await()
//        val res2 = two.await()
//
//    }
//
//    println("Completed my execution")


//    try {
//        val res = fetchDataAsync()
//        println("Response is $res")
//
//    }catch (e : Exception){
//        println("Error is $e")
//
//    }x

        CoroutineScope(Dispatchers.IO).launch(handler) {
            println("first")
            throw Exception("JGOD")
        }







    delay(1000)




}

suspend fun fetchDataAsync() = suspendCancellableCoroutine { continuation ->

    fetchData { result, error ->
        if (error != null) {
            continuation.resumeWithException(error) // Resume with error
        } else {
            continuation.resume(result!!) // Resume with the result
        }
    }
    continuation.invokeOnCancellation {
        println("Job is cancelled")
    }
}



 fun fetchData(callBack : (String?,Throwable?) -> Unit) {

    try {
        callBack("Success" ,null)
    }catch (e : Exception){
        callBack(null,e)
    }
}

val handler = CoroutineExceptionHandler { _, throwable ->
    println("Handled exception: ${throwable.message}")
}


