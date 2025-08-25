package patterns

// start with red
//class TrafficLight {
//     private var color: String = "RED"
//
//    fun next() {
//        when (color) {
//            "RED" -> {
//                color = "GREEN"
//                println("Light changed from RED to GREEN. Cars go!")
//            }
//
//            "GREEN" -> {
//                color = "YELLOW"
//                println("Light changed from GREEN to YELLOW. Slow down!")
//            }
//
//            "YELLOW" -> {
//                color = "RED"
//                println("Light changed from YELLOW to RED. Stop!")
//            }
//        }
//    }
//}
//fun main() {
//    val trafficLight = TrafficLight()
//    trafficLight.next() // from RED to GREEN
//    trafficLight.next() // from GREEN to YELLOW
//    trafficLight.next() // from YELLOW to RED
//}

// Concrete State: Red
internal class RedState : TrafficLightState {
    override fun next(context: TrafficLightContext) {
        println("Switching from RED to GREEN. Cars go!")
        context.setState(GreenState())
    }

    override val color: String
        get() = "RED"
}

// Concrete State: Green
internal class GreenState : TrafficLightState {
    override fun next(context: TrafficLightContext) {
        println("Switching from GREEN to YELLOW. Slow down!")
        context.setState(YellowState())
    }

    override val color: String
        get() = "GREEN"
}

// Concrete State: Yellow
internal class YellowState : TrafficLightState {
    override fun next(context: TrafficLightContext) {
        println("Switching from YELLOW to RED. Stop!")
        context.setState(RedState())
    }

    override val color: String
        get() = "YELLOW"
}

    class TrafficLightContext {
        private var currentState: TrafficLightState = RedState()

        fun setState(state: TrafficLightState) {
            this.currentState = state
        }

        fun next() {
            currentState.next(context = this)
        }

        val color: String?
            get() = currentState.color
    }


    interface TrafficLightState {
        fun next(context: TrafficLightContext)
        val color: String?
    }

fun main() {
    val trafficLight = TrafficLightContext()
    trafficLight.next() // RED -> GREEN
    trafficLight.next() // GREEN -> YELLOW
    trafficLight.next() // YELLOW -> RED
    trafficLight.next() // RED -> GREEN
}
