package low_level_designs.discountengine.model


data class CartItem(
    val product: Product,
    val quantity: Int
) {
    fun itemTotal(): Double = product.price * quantity
}
