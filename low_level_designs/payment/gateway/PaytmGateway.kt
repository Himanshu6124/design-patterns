package low_level_designs.payment.gateway

import low_level_designs.payment.external.BankingSystem
import low_level_designs.payment.external.PaytmBankingSystem
import low_level_designs.payment.model.PaymentRequest

class PaytmGateway : PaymentGateway() {

    override val maxRetry: Int
        get() = 4

    override var bankingSystem: BankingSystem = PaytmBankingSystem()


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

    val paytm = PaytmGateway()
    val request = PaymentRequest(
        sender = "himanshu",
        receiver = "jod",
        amount = 10.0
    )
    paytm.payWithRetry(request)
}