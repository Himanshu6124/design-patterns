package low_level_designs.discountengine

import low_level_designs.discountengine.coupon.BankingCoupon
import low_level_designs.discountengine.coupon.BulkPurchaseDiscount
import low_level_designs.discountengine.coupon.LoyaltyDiscount
import low_level_designs.discountengine.coupon.SeasonalOffer
import low_level_designs.discountengine.manager.CouponManager
import low_level_designs.discountengine.model.Cart
import low_level_designs.discountengine.model.Product



fun main() {

    CouponManager.registerCoupon(
        SeasonalOffer(10.0, "Clothing")
    )

    CouponManager.registerCoupon(
        LoyaltyDiscount(5.0)
    )

    CouponManager.registerCoupon(
        BulkPurchaseDiscount(1000.0, 100.0)
    )

    CouponManager.registerCoupon(
        BankingCoupon("ABC", 2000.0, 15.0, 500.0)
    )

    val cart = Cart()

    cart.addProduct(
        Product("Winter Jacket", "Clothing", 1000.0)
    )

    cart.addProduct(
        Product("Smartphone", "Electronics", 20000.0)
    )

    cart.loyaltyMember = true
    cart.paymentBank = "ABC"

    println("Original Total = ${cart.originalTotal}")

    CouponManager.getApplicable(cart)
        .forEach(::println)

    println(
        "Final Total = ${CouponManager.applyAll(cart)}"
    )
}