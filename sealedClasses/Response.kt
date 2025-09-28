package sealedClasses

sealed interface Response{
    class Success(val data: String): Response
    class Error(val error: String): Response
}
fun handleResponse(response: Response){
    when(response){
        is Response.Success -> {}
        is Response.Error -> {}
    }
}


sealed interface ResponseT{
    class Success<T>(val data: T): ResponseT
    class Error(val error: String): ResponseT
}

fun handleResponseT(response: ResponseT){
    when(response){

        is ResponseT.Success<*> -> {

            val data: Int? = response.data as? Int
            println("responseT Success: $data")

        }
        is ResponseT.Error -> {
            println("responseT Error: ${response.error}")
        }
    }
}



fun main() {

    val res = Response.Error("yes")
    handleResponse(res)

    val resT = ResponseT.Success("42")
    handleResponseT(resT)

}