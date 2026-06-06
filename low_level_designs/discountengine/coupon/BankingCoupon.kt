package low_level_designs.discountengine.coupon

import low_level_designs.discountengine.enums.StrategyType
import low_level_designs.discountengine.manager.DiscountStrategyManager
import low_level_designs.discountengine.model.Cart

class BankingCoupon(
    private val bank: String,
    private val minSpend: Double,
    private val percent: Double,
    private val offCap: Double
) : Coupon() {

    private val strategy =
        DiscountStrategyManager.getStrategy(
            StrategyType.PERCENT_WITH_CAP,
            percent,
            offCap
        )

    override fun isApplicable(cart: Cart): Boolean {
        return cart.paymentBank == bank &&
                cart.originalTotal >= minSpend
    }

    override fun getDiscount(cart: Cart): Double {
        return strategy.calculate(cart.currentTotal)
    }

    override fun name(): String {
        return "$bank Bank ${percent.toInt()}% off upto ${offCap.toInt()}"
    }
}