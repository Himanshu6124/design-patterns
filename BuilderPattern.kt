package com.droame.createbooking.app.common.view

class Mobile()
{
    private var brand : String? = null
    private var ram : Int = 0
    private var isFastCharging : Boolean = false
    private var is5G : Boolean = false

    constructor(builder: MobileBuilder) : this(){
        brand = builder.brand
        ram = builder.ram
        isFastCharging =builder.fastCharging
        is5G = builder.is5G
    }

    fun printMobile(){
        println("Brand $brand RAM $ram Fast Charging $isFastCharging 5G $is5G")
    }

    //required
    class MobileBuilder(var brand: String, var ram: Int) {

        var fastCharging : Boolean = false
        var is5G : Boolean = false

        //optional
        fun is5gSupported(is5G : Boolean) : MobileBuilder{
            this.is5G = is5G
            return this
        }

        //optional
        fun isFastCharging(fastCharge : Boolean) : MobileBuilder{
            this.fastCharging = fastCharge
            return this
        }

        fun build() : Mobile{
            return Mobile(this)
        }
    }
}

fun main(){
    val mobile = Mobile
                .MobileBuilder("SAMSUNG",8)
                .isFastCharging(true)
                .is5gSupported(true)
                .build()

    mobile.printMobile()
}