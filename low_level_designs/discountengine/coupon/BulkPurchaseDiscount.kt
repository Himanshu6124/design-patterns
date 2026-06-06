package low_level_designs.discountengine.coupon

import low_level_designs.discountengine.enums.StrategyType
import low_level_designs.discountengine.manager.DiscountStrategyManager
import low_level_designs.discountengine.model.Cart

class BulkPurchaseDiscount(
    private val threshold: Double,
    private val flatOff: Double
) : Coupon() {

    private val strategy =
        DiscountStrategyManager.getStrategy(
            StrategyType.FLAT,
            flatOff
        )

    override fun isApplicable(cart: Cart): Boolean {
        return cart.originalTotal >= threshold
    }

    override fun getDiscount(cart: Cart): Double {
        return strategy.calculate(cart.currentTotal)
    }

    override fun name(): String {
        return "Bulk Purchase Rs ${flatOff.toInt()} off over ${threshold.toInt()}"
    }
}