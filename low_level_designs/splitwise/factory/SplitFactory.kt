package low_level_designs.splitwise.factory

import low_level_designs.splitwise.enums.SplitType
import low_level_designs.splitwise.strategy.EqualSplitStrategy
import low_level_designs.splitwise.strategy.ExactSplitStrategy
import low_level_designs.splitwise.strategy.PercentSplitStrategy
import low_level_designs.splitwise.strategy.SplitStrategy

object SplitFactory {

    fun getSplitStrategy(type: SplitType) : SplitStrategy{
        return when(type){
            SplitType.EQUAL -> EqualSplitStrategy()
            SplitType.EXACT -> ExactSplitStrategy()
            SplitType.PERCENTAGE -> PercentSplitStrategy()
        }
    }
}