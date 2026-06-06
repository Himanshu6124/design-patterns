package low_level_designs.discountengine.strategy

interface DiscountStrategy {
    fun calculate(baseAmount: Double): Double
}