package patterns

import patterns.Mobile.MobileBuilder

class Mobile(){

    var brand : String? = null
    var isFastCharging: Boolean = false
    var ram : String = "8GB"
    var is5g = false

    constructor(mobile: MobileBuilder) : this(){
        this.brand = mobile.brand
        this.isFastCharging = mobile.isFastChargeSupported
        this.ram = mobile.ram
        this.is5g = mobile.is5gsupported
    }

    fun printMobile(){
        println(this.ram)
        println(this.brand)
        println(this.is5g)
        println(this.isFastCharging)
    }




    class MobileBuilder(val brand :String,val ram : String){

         var is5gsupported = false
         var isFastChargeSupported = false

        fun is5gSupported(isSupported :Boolean) : MobileBuilder{
            this.is5gsupported = isSupported
            return this

        }

        fun isFastChargingSupported(isSupported : Boolean) : MobileBuilder{
            this.isFastChargeSupported = isSupported
            return this
        }

        fun build() : Mobile{
            return Mobile(this)
        }
    }

}

fun main(){
    val mobile = MobileBuilder("SAMSUNG","16GB")
        .isFastChargingSupported(true)
        .is5gSupported(false)
        .build()

    mobile.printMobile()

}