package low_level_designs.discountengine.strategy

class FlatDiscountStrategy(
    private val amount: Double
) : DiscountStrategy {
    override fun calculate(baseAmount: Double): Double {
        return minOf(amount, baseAmount)
    }
}