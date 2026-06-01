package low_level_designs.zomato.notification

import low_level_designs.zomato.model.Order

interface NotificationStrategy {
    fun sendNotification(order: Order)
}