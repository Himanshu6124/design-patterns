package sealed

sealed interface UiState {
    class Loading(val message: String) : UiState
    class Success<T>(val data: T) : UiState
    class Error(val error: Exception) : UiState
}

fun main(){
    val uiState : UiState = UiState.Loading("loading")
//    when(uiState){
//        is UiState.Error -> TODO()
//        is UiState.Loading -> TODO()
//        is UiState.Success -> TODO()
//    }

    val myDog = Dog("Rufus")
    val myCat = Cat("Whiskers")
    makeSound(myDog) // outputs: "Rufus says woof!"
    makeSound(myCat) // outputs: "Whiskers says meow!"
}

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()
}


sealed class Animal(val name: String)
class Dog(private val n: String): Animal(n)
class Cat(private val n: String): Animal(n)

fun makeSound(animal: Animal) = when (animal) {
    is Dog -> println("${animal.name} says woof!")
    is Cat -> println("${animal.name} says meow!")
}

