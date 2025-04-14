

fun printValues(fn: () -> Unit) {
    for (i in 1..5) {
        println(i)
    }
}


inline fun processData( action: () -> Unit) {
    println("Processing")
//    val runnable = Runnable { action() } // Action is inlined but must not return non-locally
//    runnable.run()
    action()
}

 fun String.isLengthy() : Boolean{
    return this.length > 3
}


fun main() {


    val a = "Himanshu"

    println(a.isLengthy())

}