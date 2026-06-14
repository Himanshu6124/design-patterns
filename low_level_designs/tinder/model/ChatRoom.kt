package low_level_designs.tinder.model

class ChatRoom(
    val id: String,
    user1Id: String,
    user2Id: String
) {

    private val participants = mutableListOf(
        user1Id,
        user2Id
    )

    private val messages = mutableListOf<Message>()

    fun addMessage(
        senderId: String,
        content: String
    ) {
        messages.add(
            Message(
                senderId = senderId,
                content = content
            )
        )
    }

    fun hasParticipant(userId: String): Boolean {
        return participants.contains(userId)
    }

    fun getMessages(): List<Message> = messages

    fun getParticipants(): List<String> = participants
}