package low_level_designs.payment.external

import low_level_designs.payment.model.PaymentRequest

class RazorpayBankingSystem : BankingSystem {
    override fun makePayment(request: PaymentRequest): Boolean {
        println("Making razor pay external payment call")
        return true
    }
}