package low_level_designs.zomato.model

import low_level_designs.zomato.payment.PaymentStrategy

abstract class Order(
    val id: String,
    val user: User,
    val restaurant: Restaurant,
    val menuItems: List<MenuItem>,
    val paymentStrategy: PaymentStrategy,
    val total: Double,
    val scheduled: String
){

    abstract fun getType() : OrderType

    fun processPayment(amount: Double) : Boolean{
        paymentStrategy.pay(amount)
        return true
    }
}


enum class OrderType {
    DELIVERY,
    PICKUP
}