package low_level_designs.splitwise.strategy

import low_level_designs.splitwise.model.Group
import low_level_designs.splitwise.model.User

interface SplitStrategy {
    fun calculateSplit(
        amount: Double,
        members: List<User>,
        values: List<Double>
    ): Map<User, Double>
}