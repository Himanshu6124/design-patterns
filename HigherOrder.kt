
// lambda passed act a body of function
fun calculate(num1:Int,num2:Int, func : (Int,Int) -> Int) :Int{
    return func(num1 + 2 , num2 - 2)

}

fun calc(list: ArrayList<Int>,fn : (Int,Int) -> Unit) {
    list.add(5)
    list.add(10)
    fn(3,4)
}


fun main(){

    val list : ArrayList<Int> = arrayListOf()

    val c = calc(list){a,b->
        println(b)

    }
//    println(c)
//    println(list)


//    val ans = calculate(
//        num1 = 5,
//        num2 = 2 ,
//        func = { a, b ->
//        println(a)
//        println(b)
//        a+b-20
//    })
//
//    println(ans)



}

fun sum(a:Int,b:Int) : Int{
    println(a)
    println(b)
    return a+b
}