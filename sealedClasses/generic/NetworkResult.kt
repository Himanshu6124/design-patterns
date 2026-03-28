package sealedClasses.generic

//sealed class NetworkResult{
//    sealed class Success<T>(val data: T) : NetworkResult()
//    sealed class Failure(val error: String) : NetworkResult()
//}
//
sealed class NetworkResultT<T>{
    class Success<T>(val data: T) : NetworkResultT<T>()
    class Failure(val error: String) : NetworkResultT<Nothing>()
}

sealed interface NetworkResult<out T>{
    data class Success<T>(val data: T) : NetworkResult<T>
    data class Failure(val error: String) : NetworkResult<Nothing>
}

fun main() {

}

//fun <T> handleResult(result: NetworkResult) {
//    when (result) {
//        is NetworkResult.Failure -> TODO()
//        is NetworkResult.Success<*> -> TODO()
//    }
//}

//fun <T> handleResultT(result: NetworkResultT<T>) {
//    when (result) {
//        is NetworkResultT.Failure -> TODO()
//        is NetworkResultT.Success -> TODO()
//    }
//}

fun <T> handleResultT(result: NetworkResult<T>) {
    when (result) {
        is NetworkResult.Failure -> {}
        is NetworkResult.Success -> {}
    }
}