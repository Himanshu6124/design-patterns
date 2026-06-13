package low_level_designs.splitwise.model

data class User(
    val name: String,
    val id: String,
    val balance: Map<User, Double>
)