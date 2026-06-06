package low_level_designs.discountengine.manager

import low_level_designs.discountengine.enums.StrategyType
import low_level_designs.discountengine.strategy.DiscountStrategy
import low_level_designs.discountengine.strategy.FlatDiscountStrategy
import low_level_designs.discountengine.strategy.PercentageDiscountStrategy
import low_level_designs.discountengine.strategy.PercentageWithCapStrategy

object DiscountStrategyManager {

    fun getStrategy(
        type: StrategyType,
        param1: Double,
        param2: Double = 0.0
    ): DiscountStrategy {
        return when (type) {
            StrategyType.FLAT ->
                FlatDiscountStrategy(param1)

            StrategyType.PERCENT ->
                PercentageDiscountStrategy(param1)

            StrategyType.PERCENT_WITH_CAP ->
                PercentageWithCapStrategy(param1, param2)
        }
    }
}