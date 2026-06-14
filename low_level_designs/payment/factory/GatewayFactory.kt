package low_level_designs.payment.factory

import low_level_designs.payment.enums.GatewayType
import low_level_designs.payment.gateway.PaymentGateway
import low_level_designs.payment.gateway.PaytmGateway
import low_level_designs.payment.gateway.RazorPayGateway
import low_level_designs.payment.proxy.PaymentGatewayProxy

object GatewayFactory {

    fun getGateway(type: GatewayType): PaymentGateway {
        return when (type) {
            GatewayType.PAYTM -> {
                PaymentGatewayProxy(
                    realGateway = PaytmGateway(),
                    retries = 3
                )
            }

            GatewayType.RAZORPAY -> {
                PaymentGatewayProxy(
                    realGateway = RazorPayGateway(),
                    retries = 1
                )
            }
        }
    }
}