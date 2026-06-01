package low_level_designs.zomato.model

import low_level_designs.zomato.payment.PaymentStrategy
import java.util.UUID

class DeliveryOrder(
    id: String = UUID.randomUUID().toString(),
    user: User,
    restaurant: Restaurant,
    menuItems: List<MenuItem>,
    paymentStrategy: PaymentStrategy,
    total: Double,
    scheduled: String,
    val userAddress: String
) : Order(
    id = id,
    user = user,
    restaurant = restaurant,
    menuItems = menuItems,
    paymentStrategy =paymentStrategy,
    total = total,
    scheduled =scheduled
) {

    override fun getType(): OrderType {
        return OrderType.DELIVERY
    }
}