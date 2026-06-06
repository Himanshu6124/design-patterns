package patterns_

abstract class Beverage {

    fun prepare() {
        boilWater()
        brew()
        pourIntoCup()
        if (customerWantsCondiments()) {
            addCondiments()
        }
    }

    open fun customerWantsCondiments(): Boolean = true

    protected open fun boilWater() {
        println("Boiling water")
    }

    private fun pourIntoCup() {
        println("Pouring into cup")
    }

    protected abstract fun brew()

    protected abstract fun addCondiments()
}


class Tea : Beverage() {

    override fun brew() {
        println("Steeping tea leaves")
    }

    override fun customerWantsCondiments(): Boolean {
        return false
    }


    override fun addCondiments() {
        println("Adding lemon")
    }
}

//class Coffee : Beverage() {
//
//    override fun brew() {
//        println("Brewing coffee")
//    }
//
//    override fun addCondiments() {
//        println("Adding sugar and milk")
//    }
//}

fun main() {
    val tea = Tea()
//    val coffee = Coffee()
    tea.prepare()
}