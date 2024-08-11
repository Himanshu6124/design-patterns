

fun calculate(a:Int,b:Int, func : (Int,Int) -> Int) :Int{
    return func(a+2,b-2)

}


fun main(){

    val ans = calculate(5,2) { a, b ->
        println(a)
        println(b)

        a+b-20
    }
    println(ans)



}

fun sum(a:Int,b:Int) : Int{
    println(a)
    println(b)
    return a+b-20
}