package lld

data class Player(val name : String, val pos : Int)
data class Dice(val number : Int)


 class Board(private val size : Int){
     private val snakes = hashMapOf<Int,Int>()
     private val ladders = hashMapOf<Int,Int>()

     fun getPosition(currentPosition : Int)  :Int{

         if(currentPosition >= size)

         if(snakes.containsKey(currentPosition)){
             return snakes[currentPosition] ?: currentPosition
         }

         if(ladders.containsKey(currentPosition)){
             return ladders[currentPosition] ?: currentPosition
         }
         return currentPosition
     }

     fun addSnakes(start : Int,end :Int){
         snakes[start] = end
     }

     fun addLadders(start : Int,end :Int){
         ladders[start] = end
     }
 }


