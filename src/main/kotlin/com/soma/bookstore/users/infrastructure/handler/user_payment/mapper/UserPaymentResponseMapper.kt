package com.soma.bookstore.users.infrastructure.handler.user_payment.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.infrastructure.handler.user_payment.response.UserPaymentResponse
import org.springframework.stereotype.Component

@Component
class UserPaymentResponseMapper: Mapper<UserPaymentResponse, UserPayment> {

    override fun map(input: UserPayment): UserPaymentResponse {
        return UserPaymentResponse(
            input.id!!,
            input.name,
            input.creditNumber,
            input.expirationMonth,
            input.expirationYear,
            input.cvv,
            input.userId
        )
    }
}