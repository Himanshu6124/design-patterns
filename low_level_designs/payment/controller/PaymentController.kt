package low_level_designs.payment.controller

import low_level_designs.payment.enums.GatewayType
import low_level_designs.payment.factory.GatewayFactory
import low_level_designs.payment.model.PaymentRequest
import low_level_designs.payment.service.PaymentService

object PaymentController {

    fun handlePayment(
        type: GatewayType,
        request: PaymentRequest
    ): Boolean {

        val gateway = GatewayFactory.getGateway(type)

        PaymentService.setGateway(gateway)

        return PaymentService.processPayment(request)
    }
}

fun main() {

    val req1 = PaymentRequest(
        sender = "Aditya",
        receiver = "Shubham",
        amount = 1000.0,
    )

    println("Processing via Paytm")
    println("------------------------------")

    val result1 = PaymentController.handlePayment(
        GatewayType.PAYTM,
        req1
    )

    println("Result: ${if (result1) "SUCCESS" else "FAIL"}")
    println("------------------------------")
    println()

    val req2 = PaymentRequest(
        sender = "Shubham",
        receiver = "Aditya",
        amount = 500.0,
    )

    println("Processing via Razorpay")
    println("------------------------------")

    val result2 = PaymentController.handlePayment(
        GatewayType.RAZORPAY,
        req2
    )

    println("Result: ${if (result2) "SUCCESS" else "FAIL"}")
    println("------------------------------")
}