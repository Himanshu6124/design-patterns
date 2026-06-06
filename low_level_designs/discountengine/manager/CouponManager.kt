package low_level_designs.discountengine.manager

import low_level_designs.discountengine.coupon.Coupon
import low_level_designs.discountengine.model.Cart


object CouponManager {

    private var head: Coupon? = null

    fun registerCoupon(coupon: Coupon) {

        if (head == null) {
            head = coupon
            return
        }

        var current = head

        while (current?.getNext() != null) {
            current = current.getNext()
        }

        current?.setNext(coupon)
    }

    fun getApplicable(cart: Cart): List<String> {

        val result = mutableListOf<String>()

        var current = head

        while (current != null) {

            if (current.isApplicable(cart)) {
                result.add(current.name())
            }

            current = current.getNext()
        }

        return result
    }

    fun applyAll(cart: Cart): Double {
        head?.applyDiscount(cart)
        return cart.currentTotal
    }
}