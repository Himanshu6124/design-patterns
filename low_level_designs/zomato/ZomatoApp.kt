package low_level_designs.zomato

import low_level_designs.zomato.factory.InstantOrderFactory
import low_level_designs.zomato.factory.OrderFactory
import low_level_designs.zomato.factory.ScheduledOrderFactory
import low_level_designs.zomato.manager.OrderManager
import low_level_designs.zomato.manager.RestaurantManager
import low_level_designs.zomato.model.Cart
import low_level_designs.zomato.model.MenuItem
import low_level_designs.zomato.model.Order
import low_level_designs.zomato.model.OrderType
import low_level_designs.zomato.model.Restaurant
import low_level_designs.zomato.model.User
import low_level_designs.zomato.notification.NotificationStrategy
import low_level_designs.zomato.notification.SMSNotification
import low_level_designs.zomato.payment.CreditCardStrategy
import low_level_designs.zomato.payment.PaymentStrategy

class ZomatoApp {

    val restaurantManager = RestaurantManager.getInstance()
    val orderManager = OrderManager.getInstance()

    init {
        initialiseRestaurants()
    }


    private fun initialiseRestaurants() {
        val r1 = Restaurant(
            name = "The Gourmet Kitchen",
            location = "New York",
            menuItems = arrayListOf(
                MenuItem("1", "Truffle Pasta", 25),
                MenuItem("2", "Grilled Salmon", 30)
            )
        )

        val r2 = Restaurant(
            name = "Sushi Zen",
            location = "Tokyo",
            menuItems = arrayListOf(
                MenuItem("3", "Salmon Nigiri", 12),
                MenuItem("4", "Dragon Roll", 18)
            )
        )

        restaurantManager.addRestaurant(r1)
        restaurantManager.addRestaurant(r2)
    }

    fun searchByLocation(location: String): List<Restaurant> {
        return restaurantManager.searchByLocation(location)
    }

    fun selectRestaurant(
        user: User,
        restaurant: Restaurant
    ) {
        if (user.cart == null) {
            user.cart = Cart(
                restaurant = restaurant,
                menuItems = arrayListOf()
            )
        } else {
            user.cart!!.restaurant = restaurant
        }
    }

    fun addToCart(
        user: User,
        itemCode: String?
    ) {
        val restaurant = user.cart?.restaurant

        if (restaurant == null) {
            println("Please select a restaurant first.")
            return
        }

        restaurant.menuItems.forEach { item ->
            if (item.id == itemCode) {
                user.cart?.addItem(item)
                return
            }
        }
    }

    fun checkoutNow(
        user: User,
        orderType: OrderType,
        paymentStrategy: PaymentStrategy
    ): Order? {
        return checkout(
            user = user,
            orderType = orderType,
            paymentStrategy = paymentStrategy,
            orderFactory = InstantOrderFactory()
        )
    }

    fun checkoutScheduled(
        user: User,
        orderType: OrderType,
        paymentStrategy: PaymentStrategy,
        scheduleTime: String
    ): Order? {
        return checkout(
            user = user,
            orderType = orderType,
            paymentStrategy = paymentStrategy,
            orderFactory = ScheduledOrderFactory(scheduleTime)
        )
    }

    private fun checkout(
        user: User,
        orderType: OrderType,
        paymentStrategy: PaymentStrategy,
        orderFactory: OrderFactory
    ): Order? {

        val cart = user.cart ?: return null

        if (cart.isEmpty()) {
            return null
        }

        val restaurant = cart.restaurant
        val items = cart.menuItems

        val order = orderFactory.creteOrder(
            user = user,
            cart = cart,
            restaurant = restaurant,
            menuItem = items,
            paymentStrategy = paymentStrategy,
            orderType = orderType
        )

        orderManager.createOrder(order)

        return order
    }

    fun payForOrder(
        user: User,
        order: Order,
        notificationStrategy: NotificationStrategy
    ) {
        val isPaymentSuccess = order.processPayment(order.total)

        if (isPaymentSuccess) {
            notificationStrategy.sendNotification(order)
            user.cart?.clear()
        }
    }

    fun printUserCart(user: User) {

        val cart = user.cart ?: return

        println("Items in cart:")
        println("------------------------------------")

        cart.menuItems.forEach {
            println("${it.id} : ${it.name} : ₹${it.price}")
        }

        println("------------------------------------")
        println("Grand total : ₹${cart.calculateCost()}")
    }
}


fun main() {
    val app = ZomatoApp()
    val restaurantList = app.searchByLocation("tokyo")

    if (restaurantList.isEmpty()) {
        println("No restaurants found!")
        return
    }
    val restaurant = restaurantList[0]

    val user = User(name = "Himanshu", address = "Noida")
    println("User: ${user.name} is active.")
    println("Restaurant is: ${restaurant.name}")


    app.selectRestaurant(
        user = user,
        restaurant = restaurant
    )

    val notificationStrategy: NotificationStrategy = SMSNotification()

    app.addToCart(
        user = user,
        itemCode = restaurant.menuItems[0].id,
    )

    val order = app.checkoutNow(
        user = user,
        orderType = OrderType.PICKUP,
        paymentStrategy = CreditCardStrategy()
    )

    app.payForOrder(
        user = user,
        order = order ?: return,
        notificationStrategy
    )
}
