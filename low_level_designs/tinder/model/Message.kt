package low_level_designs.tinder.model

data class Message(
    val senderId: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)