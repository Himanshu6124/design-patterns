package coroutines

import isLengthy
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.time.measureTime


// fun main(): Unit = runBlocking {
////    println("Before")
////    suspendCoroutine { continuation ->
////        continuation.resume(Unit)
////    }
////    delay(1000)
////    println("After")
//
//
//    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        println("CoroutineException Caught exception: ${throwable.message}")
//    }
//
//    GlobalScope.launch(Dispatchers.IO + exceptionHandler + CoroutineName("")) {
//        println("CoroutineException Caught exception: $")
//
//        var x  = 5/0
//
//    }
//
//}

suspend fun postItem(item: String) {

    val token = requestToken(
        onToken = { token ->
            val posts = getPosts(item, token)
            print(posts)
        })
}



suspend fun requestToken(onToken: (String) -> Unit) {
    val token = "123"
    onToken(token)
}

fun getPosts(item: String, token: String): ArrayList<String> {

    return arrayListOf("Apple", "Samsung", "HP")
}

//suspend fun postItems(item:String){
//
//    val token = requestToken()
//    val posts = getPosts(item, token)
//    processPosts()
//}

//fun main(): Unit = runBlocking{

//    supervisorScope {
//        launch {
//            throw Exception("dgd")
//        }
//        launch {
//            println("JOD")
//        }
//    }

//    val address = Address("VBN","UP")
//    val person = Person("Himanshu", 20,address)
//
//    val deepCopied = person.clone(person) // deep copy
//    val shallowCopied = person.copy() // shallow copy
//
//    person.address.state = "MP"
//    println(deepCopied.address.state)  // original unchanged
//    println(shallowCopied.address.state) // original modified

//    val str = "Himanshu"
//
//    higherOrder {
//        isLonger()
//    }


//}

fun higherOrder(fn : String.()->Unit){
    val str = "Himanshu"
    str.fn()
}


fun String.isLonger() {
    println(" $this is Longer")
}




















//suspend fun a() : Int{
//    delay(2000)
//    return 20
//}
//suspend fun b() : Int{
//    delay(3000)
//    return 10
//}
//
data class Address(var city :String, var state :String)
data class Person(var name: String, val age: Int,var address: Address){
    fun clone(person: Person) : Person{
        val newAddress = Address(person.address.city,person.address.state)
        return Person(name,age,newAddress)

    }
}


