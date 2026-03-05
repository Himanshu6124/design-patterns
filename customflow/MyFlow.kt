package customflow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

interface Collector<T> {
    suspend fun emit(value: T)
}

interface MyFlow<T> {
    suspend fun collect(collector: Collector<T>)
}

class SimpleFlow<T>(
    private val block: suspend Collector<T>.() -> Unit
) : MyFlow<T> {

    override suspend fun collect(collector: Collector<T>) {
        collector.block()
    }
}

suspend fun <T> MyFlow<T>.collect(
    action: suspend (T) -> Unit
) {
    collect(object : Collector<T> {
        override suspend fun emit(value: T) {
            action(value)
        }
    })
}



fun main() {
    runBlocking {

        val flow = SimpleFlow {
            emit(1)
            emit(2)
            emit(3)
        }


        flow.collect(object : Collector<Int> {
            override suspend fun emit(value: Int) {
                println("Received: $value")
            }
        })

    }
}

