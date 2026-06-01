package loopers

import java.util.concurrent.LinkedBlockingQueue


class Looper {
    private val queue = MessageQueue()

    fun loop() {
        while (true) {
            val task = queue.next()
            task.run()
        }
    }

    fun getQueue(): MessageQueue {
        return queue
    }
}

class Handler(private val looper: Looper) {

    fun post(task: Runnable) {
        looper.getQueue().enqueue(task)
    }
}

class MessageQueue {

    private val queue = LinkedBlockingQueue<Runnable>()

    fun enqueue(task: Runnable) {
        queue.put(task)
    }

    fun next(): Runnable {
        return queue.take()
    }
}

fun main() {

    val looper = Looper()

    val handler = Handler(looper)

    Thread {
        looper.loop()
    }.start()

    handler.post(Runnable {
        println("First Task")
    })

    handler.post(Runnable {
        println("Second Task")
    })
}