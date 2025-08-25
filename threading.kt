import kotlinx.coroutines.internal.synchronized

class ThreadA : Thread(){

    override fun run() {
        throw Exception("dfdf")
        println("Running Thread ${currentThread().name}")
    }

}

class MyRunnable : Runnable{
    override fun run() {
        println("JOD A")
    }
}

val myRunnable = Runnable(
    function = {
        println("JOD B")
    }
)


fun main(){

    val thread = Thread(MyRunnable())
    val threadB = Thread(myRunnable)
    val t = ThreadA().start()
    println("${Thread.currentThread().name} is Running ")


//    thread.start()
//    threadB.start()


}