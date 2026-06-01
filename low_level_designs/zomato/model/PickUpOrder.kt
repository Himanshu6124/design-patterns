package low_level_designs.zomato.model

import low_level_designs.zomato.payment.PaymentStrategy
import java.util.UUID

class PickupOrder(
    id: String = UUID.randomUUID().toString(),
    user: User,
    restaurant: Restaurant,
    menuItems: List<MenuItem>,
    paymentStrategy: PaymentStrategy,
    total: Double,
    scheduled: String,
    val restaurantAddress: String
) : Order(
    id,
    user,
    restaurant,
    menuItems,
    paymentStrategy,
    total,
    scheduled
) {

    override fun getType(): OrderType {
        return OrderType.PICKUP
    }
}