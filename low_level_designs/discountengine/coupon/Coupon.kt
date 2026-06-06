package low_level_designs.discountengine.coupon

import low_level_designs.discountengine.model.Cart


// ----------------------------
// Coupon (Chain of Responsibility)
// ----------------------------
abstract class Coupon {

    private var next: Coupon? = null

    fun setNext(coupon: Coupon) {
        next = coupon
    }

    fun getNext(): Coupon? = next

    fun applyDiscount(cart: Cart) {

        if (isApplicable(cart)) {

            val discount = getDiscount(cart)

            cart.applyDiscount(discount)

            println("${name()} applied: $discount")

            if (!isCombinable()) return
        }

        next?.applyDiscount(cart)
    }

    abstract fun isApplicable(cart: Cart): Boolean

    abstract fun getDiscount(cart: Cart): Double

    open fun isCombinable(): Boolean = true

    abstract fun name(): String
}