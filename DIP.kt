interface MessageService {
    fun sendMessage(message: String)
}

class SMSService : MessageService {

    override fun sendMessage(message: String) {
        println("Sending text message $message")
    }
}

class EmailService : MessageService {

    override fun sendMessage(message: String) {
        println("Sending email message $message")
    }
}

class MessageSender(private val messageService: MessageService) {
    fun sendMessage(message: String) {
        messageService.sendMessage(message)
    }
}


fun main() {
    val smsService = SMSService()
    val messageSender = MessageSender(smsService)
    messageSender.sendMessage("SMS")

    val emailService = EmailService()
    val emailSender = MessageSender(emailService)
    emailSender.sendMessage("EMAIL")

}




