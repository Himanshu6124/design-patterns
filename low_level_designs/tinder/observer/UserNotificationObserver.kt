package low_level_designs.tinder.observer

class UserNotificationObserver(
    private val userId: String
) : NotificationObserver {

    override fun update(message: String) {
        println("Notification for user $userId : $message")
    }
}