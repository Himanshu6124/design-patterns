package lld.parkinglot

interface PaymentStrategy {
    fun pay(amount: Double)
}


class CreditCardPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using credit card")
    }
}

class CashPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using cash")
    }
}

class UPIPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using UPI")
    }
}