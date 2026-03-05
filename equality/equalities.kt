package equality

fun main(){

//    val a = 4
//    val b = 4

    val a = "hello"
    val b = "hello"
    val s1 = Student("Amit")
    val s2 = Student("Amit")

//    println(a == b)
//    println(a === b)

    println(s1 == s2)
    println(s1 === s2)
}

data class Student(val name: String)