package context

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class Student {
    val name: String
    val age: Int

    constructor(name : String, age : Int){
        this.name = name
        this.age = age
    }

}

fun main(){
    val scope = GlobalScope

    scope.launch {
        println("before")
        delay(100)
        println("after")
    }
}