package com.soma.bookstore.users.infrastructure.handler.user_payment.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.infrastructure.handler.user_payment.request.UserPaymentUpdateRequest
import org.springframework.stereotype.Component

@Component
class UserPaymentUpdateRequestMapper: Mapper<UserPayment, UserPaymentUpdateRequest> {

    override fun map(input: UserPaymentUpdateRequest): UserPayment {
        return UserPayment(
            name = input.name,
            creditNumber = input.creditNumber,
            expirationMonth = input.expirationMonth,
            expirationYear = input.expirationYear,
            cvv = input.cvv,
            userId = input.userId
        )
    }
}