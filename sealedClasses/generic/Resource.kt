package sealedClasses.generic

sealed class Resource{
    data class Success<T>(val data : T) : Resource()
    data class Error(val message : String) : Resource()
}
//sealed class Result<out T> {
//    data class Success<out T>(val data: T) : Result<T>()
//    data class Error(val error: kotlin.Error) : Result<Nothing>()
//}
