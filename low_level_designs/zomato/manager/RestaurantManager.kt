package low_level_designs.zomato.manager

import low_level_designs.zomato.model.Restaurant

class RestaurantManager {

    val restaurants : ArrayList<Restaurant> = arrayListOf()

    fun addRestaurant(restaurant: Restaurant){
        restaurants.add(restaurant)
    }

    fun removeRestaurant(restaurant: Restaurant){
        restaurants.remove(restaurant)
    }

    fun searchByLocation(name: String) : List<Restaurant> {
        val result : ArrayList<Restaurant> = arrayListOf()
        restaurants.forEach {
            if (it.location.contains(name,true)){
                result.add(it)
            }
        }
        return result
    }


    companion object {
        @Volatile
        private var instance: RestaurantManager? = null
        fun getInstance(): RestaurantManager {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = RestaurantManager()
                    }
                }
            }
            return instance!!
        }
    }
}


fun main() {
    val restaurantManager = RestaurantManager.getInstance()
}