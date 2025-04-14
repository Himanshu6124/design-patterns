import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Timer {

    private var currentSeconds = 0
    private var isTimerRunning = false
    private val scope = CoroutineScope(Dispatchers.IO)

    fun startTimer(onSuccess: () -> Unit, onFailure: (String?) -> Unit, callback: TimerCallback) {

        try {
            isTimerRunning = true
            onSuccess()
            scope.launch {
                while (isTimerRunning) {
                    delay(1000)
                    currentSeconds++
                    callback.onTimerUpdate(currentSeconds)
                }
            }

        } catch (e: Exception) {
            onFailure(e.message)
        }
    }

    fun stopTimer() {
        currentSeconds = 0
        isTimerRunning = false
    }
}

interface TimerCallback {
    fun onTimerUpdate(seconds: Int)
}


fun main() = runBlocking {

    val timer = Timer()
    timer.startTimer(
        onSuccess = { println("Timer started") },
        onFailure = { print("Timer start error $it") },
        callback = object : TimerCallback {
            override fun onTimerUpdate(seconds: Int) {
                println("Timer is $seconds")
            }
        }
    )
    delay(10000)
    timer.stopTimer()
}