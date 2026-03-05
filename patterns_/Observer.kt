package patterns_

interface Observer{
    fun onNotified(publisher: Publisher)
}


interface Publisher {


    fun subscribe(observer: Observer)
    
    fun unSubscribe(observer: Observer)

    fun notifyObservers()

}


class YtStubscriber : Observer {
    override fun onNotified(publisher: Publisher) {
        println("received from channel $publisher")
    }
}


class PublisherChannel : Publisher {

    val observers : ArrayList<Observer> = ArrayList()

    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    override fun unSubscribe(observer: Observer) {
        observers.remove(observer)

    }

    override fun notifyObservers() {

        for (observer in observers){
            observer.onNotified(this)
        }
    }
}


fun main(){
    val subscriber = YtStubscriber()
    val publisher = PublisherChannel()
    publisher.subscribe(subscriber)
    publisher.notifyObservers()
    
}