package low_level_designs.splitwise.model

data class Group(
    val id: String,
    val name: String,
    val members: List<User>,
    val expenses: List<Expense>
)