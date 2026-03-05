package livedata

class LiveData<T>(initial : T){

    private var value : T? = initial
    private var observers : HashMap<Lifecycle,Observer<T>> = hashMapOf()

    fun setValue(value: T){
        this.value = value
        notifyObservers()
    }

    fun getValue() : T?{
        return value
    }

    fun addObserver(lifecycle: Lifecycle, observer: Observer<T>){
        observers[lifecycle] = observer
    }

    fun removeObserver(lifecycle: Lifecycle){
        observers.remove(lifecycle)
    }

    fun notifyObservers(){
        observers.forEach { it.value.onChanged(value) }
    }

}

fun main(){
    val liveData = LiveData("Hello")

    liveData.addObserver(Lifecycle.CREATED, object : Observer<String>{
        override fun onChanged(value: String?) {
            println("Observer 1: $value")
        }
    })

    liveData.setValue("World")
}


enum class Lifecycle{
    CREATED,
    STARTED,
    RESUMED,
    DESTROYED
}





interface Observer<T>{
    fun onChanged(value: T?)

}