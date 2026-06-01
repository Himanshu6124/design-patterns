package low_level_designs.zomato.payment

class UPIStrategy : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying using UPI $amount")
    }
}