package low_level_designs.payment.gateway

import low_level_designs.payment.external.BankingSystem
import low_level_designs.payment.external.RazorpayBankingSystem
import low_level_designs.payment.model.PaymentRequest

class RazorPayGateway : PaymentGateway() {

    override val maxRetry: Int
        get() = 4

    override var bankingSystem: BankingSystem = RazorpayBankingSystem()

    override fun process(request: PaymentRequest): Boolean {
        bankingSystem.makePayment(request)
        println("Processing UPI request for ${request.amount}")
        return true
    }

    override fun confirmation(request: PaymentRequest): Boolean {
        println("Confirming UPI request for ${request.amount}")
        return true
    }
}



fun main(){

    val razorPay = RazorPayGateway()
    val request = PaymentRequest(
        sender = "himanshu",
        receiver = "jod",
        amount = 10.0
    )
    razorPay.payWithRetry(request)
}