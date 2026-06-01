package low_level_designs.zomato.model

import java.util.UUID

data class Cart(
    val id: String = UUID.randomUUID().toString(),
    val menuItems: ArrayList<MenuItem>,
    var restaurant: Restaurant,
) {

    fun addItem(item: MenuItem) {
        menuItems.add(item)
    }

    fun removeItem(item: MenuItem) {
        menuItems.remove(item)
    }

    fun calculateCost(): Double {
        return menuItems.sumOf { it.price.toDouble() }
    }

    fun isEmpty(): Boolean{
        return menuItems.isEmpty()
    }

    fun clear(){
        menuItems.clear()
    }
}
