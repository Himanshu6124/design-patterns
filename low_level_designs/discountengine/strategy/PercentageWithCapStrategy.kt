package low_level_designs.discountengine.strategy

class PercentageWithCapStrategy(
    private val percent: Double,
    private val cap: Double
) : DiscountStrategy {
    override fun calculate(baseAmount: Double): Double {
        return minOf((percent / 100.0) * baseAmount, cap)
    }
}