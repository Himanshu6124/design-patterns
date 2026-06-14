package low_level_designs.payment.gateway

import low_level_designs.payment.external.BankingSystem
import low_level_designs.payment.model.PaymentRequest

abstract class PaymentGateway {

    protected open lateinit var bankingSystem : BankingSystem
    private var retryCount = 0
    protected open val maxRetry = 3
    open fun processPayment(request: PaymentRequest) : Boolean{
        if(!validate(request)) return false
        if(!process(request)) return false
        return confirmation(request)
    }

    fun payWithRetry(request: PaymentRequest): Boolean{
        println("retrying $maxRetry times")
        while(retryCount < maxRetry){
            if(processPayment(request)){
                return true
            }else{
                retryCount++
            }
        }
        return false
    }

     open fun validate(request: PaymentRequest): Boolean{
        println("Validating request for ${request.amount}")
        return request.amount > 0
    }
    abstract fun process(request: PaymentRequest): Boolean
    abstract fun confirmation(request: PaymentRequest): Boolean
}