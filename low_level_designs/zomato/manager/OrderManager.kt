package low_level_designs.zomato.manager

import low_level_designs.zomato.model.Order
import low_level_designs.zomato.model.User

class OrderManager {

    private val orders = mutableListOf<Order>()

    fun createOrder(order: Order) {
        orders.add(order)
    }

    fun getOrderById(orderId: String): Order? {
        return orders.find { it.id == orderId }
    }

    fun getOrdersByUser(user: User): List<Order> {
        return orders.filter { it.user == user }
    }

    fun processOrderPayment(orderId: String, amount: Double) {
        val order = getOrderById(orderId)
            ?: throw IllegalArgumentException("Order not found")

        order.processPayment(amount)
    }

    fun getAllOrders(): List<Order> {
        return orders.toList()
    }

    fun cancelOrder(orderId: String) {
        orders.removeIf { it.id == orderId }
    }

    companion object {
        @Volatile
        private var instance: OrderManager? = null
        fun getInstance(): OrderManager {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = OrderManager()
                    }
                }
            }
            return instance!!
        }
    }
}