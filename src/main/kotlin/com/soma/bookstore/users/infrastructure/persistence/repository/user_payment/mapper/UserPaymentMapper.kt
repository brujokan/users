package com.soma.bookstore.users.infrastructure.persistence.repository.user_payment.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.infrastructure.persistence.entity.UserPaymentEntity
import org.springframework.stereotype.Component

@Component
class UserPaymentMapper: Mapper<UserPayment, UserPaymentEntity> {

    override fun map(input: UserPaymentEntity): UserPayment {
        return UserPayment(
            input.id,
            input.name!!,
            input.creditNumber!!,
            input.expirationMonth!!,
            input.expirationYear!!,
            input.cvv,
            input.userId
        )
    }
}