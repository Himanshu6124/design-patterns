package low_level_designs.tinder.service

import low_level_designs.tinder.observer.NotificationObserver

object NotificationService {

    private val observers = mutableMapOf<String, NotificationObserver>()

    fun registerObserver(
        userId: String,
        observer: NotificationObserver
    ) {
        observers[userId] = observer
    }

    fun removeObserver(userId: String) {
        observers.remove(userId)
    }

    fun notifyUser(
        userId: String,
        message: String
    ) {
        observers[userId]?.update(message)
    }

    fun notifyAll(message: String) {
        observers.values.forEach {
            it.update(message)
        }
    }
}