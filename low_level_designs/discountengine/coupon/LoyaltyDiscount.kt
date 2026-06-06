package low_level_designs.discountengine.coupon

import low_level_designs.discountengine.enums.StrategyType
import low_level_designs.discountengine.manager.DiscountStrategyManager
import low_level_designs.discountengine.model.Cart

class LoyaltyDiscount(
    private val percent: Double
) : Coupon() {

    private val strategy =
        DiscountStrategyManager.getStrategy(
            StrategyType.PERCENT,
            percent
        )

    override fun isApplicable(cart: Cart): Boolean {
        return cart.loyaltyMember
    }

    override fun getDiscount(cart: Cart): Double {
        return strategy.calculate(cart.currentTotal)
    }

    override fun name(): String {
        return "Loyalty Discount ${percent.toInt()}% off"
    }
}