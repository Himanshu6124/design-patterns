package low_level_designs.payment.external

import low_level_designs.payment.model.PaymentRequest

class PaytmBankingSystem : BankingSystem {
    override fun makePayment(request: PaymentRequest): Boolean {
        println("Making Paytm pay external payment call")
        return true
    }
}