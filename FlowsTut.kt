import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

val coroutineScope = CoroutineScope(Dispatchers.Default)

//val sharedFlow = flowOf("a", "b", "c").shareIn(coroutineScope, SharingStarted.Eagerly)
//
//fun main() {
//    coroutineScope.launch {
//        delay(1) // or something that takes a little bit of time
//        sharedFlow.collect { println("Consumer 1: $it") }
//    }
//}