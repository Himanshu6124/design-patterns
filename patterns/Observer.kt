package patterns


interface Subject{
    fun subscribe(observer: Observer)
    fun unSubscribe(observer: Observer)
    fun notifyObservers(msg: String)
}

interface Observer{
    fun notified(msg: String)
}


class Channel : Subject {

    private val observers = arrayListOf<Observer>()

    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    override fun unSubscribe(observer: Observer) {
        observers.remove(observer)
    }

    fun videoUploaded(){
        println("New video uploaded")
        notifyObservers("New video uploaded")
    }

    override fun notifyObservers(msg :String) {
        observers.forEach {
            it.notified(msg)
        }
    }
}

class Subscriber(private val name :String) : Observer {
    override fun notified(msg: String) {
        println("$name notified about $msg")
    }
}

fun main()
{
    val channel = Channel()
    val subscriber = Subscriber("Himanshu")
    val subscribe2 = Subscriber("JOD")

    channel.subscribe(subscriber)
    channel.subscribe(subscribe2)
    channel.videoUploaded()

    val address = Address("HP")
    val newA= address.copy("dfds")
}

data class Address(val city : String) : Cloneable{



}