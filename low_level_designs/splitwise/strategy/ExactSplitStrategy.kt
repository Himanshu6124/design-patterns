package low_level_designs.splitwise.strategy

import low_level_designs.splitwise.model.User

class ExactSplitStrategy : SplitStrategy  {
    override fun calculateSplit(
        amount: Double,
        members: List<User>,
        values: List<Double>
    ): Map<User, Double> {


        require(members.size == values.size){
            "Members and values count must match"
        }
        require(values.sum() == amount){
            "amount should be equal to sum of all values"
        }

        val mp = mutableMapOf<User, Double>()

        members.forEachIndexed { index, user ->
            mp[user] = values[index]
        }
        return mp

    }
}