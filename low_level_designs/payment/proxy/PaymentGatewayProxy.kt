package low_level_designs.payment.proxy

import low_level_designs.payment.gateway.PaymentGateway
import low_level_designs.payment.model.PaymentRequest

class PaymentGatewayProxy(
    private val realGateway: PaymentGateway,
    private val retries: Int
) : PaymentGateway() {

    override fun processPayment(request: PaymentRequest): Boolean {

        var result: Boolean

        repeat(retries) { attempt ->

            if (attempt > 0) {
                println(
                    "[Proxy] Retrying payment (attempt ${attempt + 1}) " +
                            "for ${request.sender}"
                )
            }

            result = realGateway.processPayment(request)

            if (result) {
                return true
            }
        }

        println(
            "[Proxy] Payment failed after $retries attempts " +
                    "for ${request.sender}"
        )

        return false
    }

    override fun validate(request: PaymentRequest): Boolean {
        return realGateway.validate(request)
    }

    override fun process(request: PaymentRequest): Boolean {
        return realGateway.process(request)
    }

    override fun confirmation(request: PaymentRequest): Boolean {
        return realGateway.confirmation(request)
    }
}