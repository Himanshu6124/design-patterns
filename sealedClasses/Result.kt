package sealedClasses

sealed class Result<T>(val status : T? =null) {
    class Success<S>(val data : S) : Result<S>()
    class Error<T>() : Result<T>()
    class Loading() : Result<Nothing>()
}

fun <T> checkResult(result : Result<T>) {
    when (result) {
        is Result.Error -> {
            println("Error")
        }
        is Result.Loading -> {
            println("Loading")
        }
        is Result.Success -> {
            val status = result.data is String
            println(status)
        }
    }
}
data class Card(
    val cardNumber: String = "1234 5678 9012 3456",
    val expiryDate: String = "12/24",
    val cardHolderName: String = "John Doe",
    val cvv: String = "123"
)

fun main() {
    val result = Result.Loading()

   checkResult<Nothing>(result)

}