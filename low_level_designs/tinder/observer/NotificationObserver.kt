package low_level_designs.tinder.observer

interface NotificationObserver {
    fun update(message: String)
}