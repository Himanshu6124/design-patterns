package low_level_designs.zomato.factory

import low_level_designs.zomato.model.Cart
import low_level_designs.zomato.model.MenuItem
import low_level_designs.zomato.model.Order
import low_level_designs.zomato.model.OrderType
import low_level_designs.zomato.model.Restaurant
import low_level_designs.zomato.model.User
import low_level_designs.zomato.payment.PaymentStrategy

interface OrderFactory {

    fun creteOrder(
        user: User,
        cart: Cart,
        restaurant: Restaurant,
        menuItem: List<MenuItem>,
        paymentStrategy: PaymentStrategy,
        orderType: OrderType
    ): Order
}