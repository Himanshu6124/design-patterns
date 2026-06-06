package low_level_designs.discountengine.strategy

class PercentageDiscountStrategy(
    private val percent: Double
) : DiscountStrategy {
    override fun calculate(baseAmount: Double): Double {
        return (percent / 100.0) * baseAmount
    }
}