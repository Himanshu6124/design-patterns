package low_level_designs.payment.model

import java.util.UUID

data class PaymentRequest(
    val id: String = UUID.randomUUID().toString(),
    val sender: String,
    val receiver: String,
    val amount: Double
)