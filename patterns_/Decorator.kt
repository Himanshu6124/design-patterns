package patterns_

interface Coffee{
    fun getCost() : Int
}


class SimpleCoffee : Coffee {
    override fun getCost(): Int {
        return 10
    }
}

// Base Decorator
abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee


class MilkDecorator(val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Int {
        return coffee.getCost() + 5
    }
}

class SugarDecorator(private val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Int {
        return coffee.getCost() + 2
    }
}


fun main(){

    val simpleCoffee = SimpleCoffee()
    val milkDecorator = MilkDecorator(simpleCoffee)
    val sugarDecorator = SugarDecorator(milkDecorator)

    println(sugarDecorator.getCost())

}