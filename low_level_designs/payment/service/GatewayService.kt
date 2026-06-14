package low_level_designs.payment.service

import low_level_designs.payment.gateway.PaymentGateway
import low_level_designs.payment.model.PaymentRequest

object PaymentService {

    private var gateway: PaymentGateway? = null

    fun setGateway(gateway: PaymentGateway) {
        this.gateway = gateway
    }

    fun processPayment(request: PaymentRequest): Boolean {
        val currentGateway = gateway

        if (currentGateway == null) {
            println("[PaymentService] No payment gateway selected.")
            return false
        }

        return currentGateway.processPayment(request)
    }
}