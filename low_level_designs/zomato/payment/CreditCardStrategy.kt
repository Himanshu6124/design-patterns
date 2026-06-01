package low_level_designs.zomato.payment

class CreditCardStrategy: PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying using credit Card $amount")
    }
}