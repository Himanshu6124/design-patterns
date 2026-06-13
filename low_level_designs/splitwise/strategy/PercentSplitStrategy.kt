package low_level_designs.splitwise.strategy

import low_level_designs.splitwise.model.User

class PercentSplitStrategy : SplitStrategy {
    override fun calculateSplit(
        amount: Double,
        members: List<User>,
        values: List<Double>
    ): Map<User, Double>  {

        require(members.size == values.size){
            "Members and percentages count must match"
        }

        val percentages = values.map { it.toDouble() }

        require(percentages.sum() == 100.0) {
            "Total percentage should be 100"
        }

        val mp = mutableMapOf<User, Double>()
        members.forEachIndexed {index, member ->
            val share = amount * values[index].toDouble() / 100
            mp[member] = share
        }
        return mp
    }
}