package patterns_


abstract class Handler{
    private var next: Handler? = null

    fun setHandler(handler: Handler) : Handler{
        next = handler
        return handler
    }

    fun handle(request: String) {
        if(!process(request)){
            next?.handle(request)
        }
    }

    abstract fun process(request: String) : Boolean
}

class FirstLevelHandler : Handler() {
    override fun process(request: String): Boolean {
        if (request.contains("tech")) {
            println("Handled by level 1")
            return true
        }
        return false
    }
}

class SecondLevelHandler : Handler() {
    override fun process(request: String): Boolean {
        if (request.contains("payment")) {
            println("Handled by level 2")
            return true
        }
        return false
    }
}

class ThirdLevelHandler : Handler() {
    override fun process(request: String): Boolean {
        if (request.contains("refund")) {
            println("Handled by level 3")
            return true
        }
        return false
    }
}

fun main(){
    val request = "payments"
    val first = FirstLevelHandler()
    val second = SecondLevelHandler()
    val third = ThirdLevelHandler()
    first.setHandler(second).setHandler(third)
    first.handle(request)
}