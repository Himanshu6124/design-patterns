package low_level_designs.payment.external

import low_level_designs.payment.model.PaymentRequest

interface BankingSystem {

    fun makePayment(request: PaymentRequest): Boolean
}