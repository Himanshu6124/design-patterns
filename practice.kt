


fun main(){
    println("hello")
//    addNum<Int>("bm")
    val a = printListItems(listOf(1,2))
 

}


 fun <T>addNum(data : T){

//     return data +5

 }

class Algebra<T> (val a : T,val b : T){


//    fun add(){
//        return a + b
//    }

}


fun <T> printListItems(list: List<T>) {
    for (item in list) {
        println(item)
    }
}
