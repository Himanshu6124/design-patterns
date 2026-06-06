package low_level_designs.discountengine.coupon

import low_level_designs.discountengine.enums.StrategyType
import low_level_designs.discountengine.manager.DiscountStrategyManager
import low_level_designs.discountengine.model.Cart

class SeasonalOffer(
    private val percent: Double,
    private val category: String
) : Coupon() {

    private val strategy =
        DiscountStrategyManager.getStrategy(
            StrategyType.PERCENT,
            percent
        )

    override fun isApplicable(cart: Cart): Boolean {
        return cart.getItems().any {
            it.product.category == category
        }
    }

    override fun getDiscount(cart: Cart): Double {
        val subtotal = cart.getItems()
            .filter { it.product.category == category }
            .sumOf { it.itemTotal() }

        return strategy.calculate(subtotal)
    }

    override fun name(): String {
        return "Seasonal Offer ${percent.toInt()}% off $category"
    }
}