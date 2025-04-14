package patterns

class A(name : String) {

    init {
        println("init block called $name")
    }

    constructor( name : String, branch : String) : this(name) {

        println("secondary const called $name and $branch")
    }


}

fun main(){

    val obj = A("Himanshu","CS")
}