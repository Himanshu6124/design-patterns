package low_level_designs.zomato.notification

import low_level_designs.zomato.model.Order

class SMSNotification : NotificationStrategy {
    override fun sendNotification(order: Order) {
        println("Sending SMS notification ${order.user.name} ${order.getType().name}")
    }
}