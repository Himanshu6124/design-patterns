package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//fun  main(): Unit = runBlocking{


//    callingFunc()

//        fn("JOD")

//    val array = arrayListOf(100,201)
//
//    val ans = array.filtered{
//        it % 2 == 0
//    }
//    println(ans)


//    val job = GlobalScope.launch {
//
//        val time = measureTimeMillis {
//            val a = coroutineScope {
//                delay(1000)
//                println("First scope")
//            }
//
//            val b =coroutineScope {
//                delay(3000)
//                println("Second scope")
//            }
//        }
//
//        println("Time is $time")
//
//    }
//    job.join()
//}

fun callingFunc(){

    higherOrderFunc {
        println("lambda")
        return
    }

    println("calling function")
}

inline fun higherOrderFunc( fn : ()-> Unit){
    println("Before")
    fn()
    println("After")
}

val fn : (String)-> Unit  = {str->
    println("Hello World $str")
}

inline fun<T> ArrayList<T>.filtered(fn: (T) -> Boolean) : ArrayList<T>{

    val ans = arrayListOf<T>()
    for(item in this){
        if(fn(item)){
            ans.add(item)
        }
    }
    return ans
}