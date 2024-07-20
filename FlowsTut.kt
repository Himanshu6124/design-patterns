import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun gelFlowValues(): Flow<Int> {
    return flow(
        block =
    {
        for (i in 1 until 5) {
            delay(1000)
            emit(i)
        }
    }
    )
}


fun main() {
    runBlocking {
        launch {
            gelFlowValues().collectLatest {
                delay(1001)
                println("Values are : $it")
            }
        }
    }
}