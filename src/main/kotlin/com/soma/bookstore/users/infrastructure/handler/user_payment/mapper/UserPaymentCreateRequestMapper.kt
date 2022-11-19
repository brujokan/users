package com.soma.bookstore.users.infrastructure.handler.user_payment.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.infrastructure.handler.user_payment.request.UserPaymentCreateRequest
import org.springframework.stereotype.Component

@Component
class UserPaymentCreateRequestMapper: Mapper<UserPayment, UserPaymentCreateRequest> {

    override fun map(input: UserPaymentCreateRequest): UserPayment {
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