


inline fun <reified T> toSet(list: List<T>): Set<T> {
    val b = list is Set<*>
    return list.toMutableSet()
}

fun main(){
    val list = listOf(1,2,3,4,5,6,7,8,9,10)
    val set = list.toSet()
    println(set)
}

inline fun <reified T> unsafeTypeCheck(value: Any): Boolean {
    // This compiles but gives warning
    return value is T  // ❌ Will not work as expected
}
