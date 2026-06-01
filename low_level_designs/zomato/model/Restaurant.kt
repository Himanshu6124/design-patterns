package low_level_designs.zomato.model

import java.util.UUID

data class Restaurant(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val location: String,
    val menuItems: ArrayList<MenuItem>
){
    fun addMenuItem(menuItem: MenuItem){
        menuItems.add(menuItem)
    }
}

