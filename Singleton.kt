class Singleton(val name: String) {

    companion object{
        private var INSTANCE : Singleton? = null

        fun getInstance(name: String): Singleton{
            if(INSTANCE == null){
                synchronized(this){
                    if (INSTANCE == null){
                        INSTANCE = Singleton(name)
                    }
                }
            }
            return INSTANCE!!
        }
    }
}

fun main(){
    val instance = Singleton.getInstance(name = "HP")
    val name = instance.name
    println(name)
    val instance2 = Singleton.getInstance(name = "CS")
    val name2 = instance2.name
    println(name2)


}