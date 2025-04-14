package delegation

interface Printer{
    fun printMessage()
}

class SimplePrinter : Printer {
    override fun printMessage() {
        println("Printing from simple printer")
    }
}

class AdvancedPrinter(simplePrinter: SimplePrinter) : Printer by simplePrinter {

    fun showAdvancedMessage(){
        printMessage()
    }

}

fun main(){
    val simplePrinter = SimplePrinter()
    val advancedPrinter = AdvancedPrinter(simplePrinter)
    advancedPrinter.printMessage()
}