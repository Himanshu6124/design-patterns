package low_level_designs.zomato.model

import java.util.UUID

data class User(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val address: String,
    var cart: Cart? = null
)