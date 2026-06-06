package low_level_designs.discountengine.model


class Cart {

    private val items = mutableListOf<CartItem>()

    var originalTotal = 0.0
        private set

    var currentTotal = 0.0
        private set

    var loyaltyMember = false

    var paymentBank = ""

    fun addProduct(product: Product, qty: Int = 1) {
        val item = CartItem(product, qty)
        items.add(item)

        originalTotal += item.itemTotal()
        currentTotal += item.itemTotal()
    }

    fun applyDiscount(discount: Double) {
        currentTotal = (currentTotal - discount).coerceAtLeast(0.0)
    }

    fun getItems(): List<CartItem> = items
}
