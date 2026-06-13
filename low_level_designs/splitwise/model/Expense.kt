package low_level_designs.splitwise.model

data class Expense(
    val id: String,
    val desc: String,
    val amount: String,
    val paidBy: String,
    val splits : Map<User, Double>
)