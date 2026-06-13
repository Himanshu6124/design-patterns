package low_level_designs.splitwise.strategy

import low_level_designs.splitwise.model.User

class EqualSplitStrategy : SplitStrategy {
    override fun calculateSplit(
        amount: Double,
        members: List<User>,
        values: List<Double>
    ): Map<User, Double> {
        val perHead = amount / members.size
        val mp = mutableMapOf<User, Double>()
        members.forEach {
            mp[it] = perHead
        }
        return mp
    }
}