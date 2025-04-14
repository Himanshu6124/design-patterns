package delegation

import kotlin.reflect.KProperty

class Delegate(initialValue: String, someFunction: (String) -> String) {

    private var storedValue: String = initialValue

    private val modify = someFunction

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "**${modify(storedValue)}**"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        storedValue = value
    }
}

class MyLazy<out T>( private val initialise :()-> T ){

    private var value : T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {

        return if (value == null) {
            value = initialise()
            value!!
        }
        else
            value!!
    }
}

fun main(){

//    val name by Delegate("Himanshu"){
//        it.toUpperCase()
//    }
//    println(name)

    val name by MyLazy{
        "Himanshu"
    }

    println(name)

}