import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

interface MyObserver<T> {
    fun onChanged(newValue : T)
}


class MyLiveData<T> {
    private var data: T? = null
    private val observers = mutableListOf<MyObserver<T>>()

    fun observe(observer: MyObserver<T>) {
        observers.add(observer)
        data?.let { observer.onChanged(it) }
    }

    fun removeObserver(observer: MyObserver<T>) {
        observers.remove(observer)
    }

    fun setValue(value: T) {
        data = value
        notifyObservers()
    }

    private fun notifyObservers() {
        for (observer in observers) {
            data?.let { observer.onChanged(it) }
        }
    }
}




fun main(){
    val myLiveData = MyLiveData<String>()

     class Observer  : MyObserver<String> {
        override fun onChanged(newValue: String) {
            println("Received: $newValue")
        }
    }

        myLiveData.observe(Observer())

        myLiveData.setValue("Hello Himanshu!")
        myLiveData.setValue("Hello Himanshu!")
}
