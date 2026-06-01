package low_level_designs.zomato.payment

interface PaymentStrategy {
    fun pay(amount: Double)
}