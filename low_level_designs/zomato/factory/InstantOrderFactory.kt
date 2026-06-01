package low_level_designs.zomato.factory

import low_level_designs.zomato.model.Cart
import low_level_designs.zomato.model.DeliveryOrder
import low_level_designs.zomato.model.MenuItem
import low_level_designs.zomato.model.Order
import low_level_designs.zomato.model.OrderType
import low_level_designs.zomato.model.PickupOrder
import low_level_designs.zomato.model.Restaurant
import low_level_designs.zomato.model.User
import low_level_designs.zomato.payment.PaymentStrategy

class InstantOrderFactory : OrderFactory {
    override fun creteOrder(
        user: User,
        cart: Cart,
        restaurant: Restaurant,
        menuItem: List<MenuItem>,
        paymentStrategy: PaymentStrategy,
        orderType: OrderType
    ): Order {
        if (orderType == OrderType.DELIVERY) {
            return DeliveryOrder(
                user = user,
                restaurant = restaurant,
                menuItems = menuItem,
                paymentStrategy = paymentStrategy,
                userAddress = user.address,
                total = cart.calculateCost(),
                scheduled = System.currentTimeMillis().toString()
            )
        } else {
            return PickupOrder(
                user = user,
                restaurant = restaurant,
                menuItems = menuItem,
                paymentStrategy = paymentStrategy,
                restaurantAddress = user.address,
                total = cart.calculateCost(),
                scheduled = System.currentTimeMillis().toString()
            )
        }
    }
}