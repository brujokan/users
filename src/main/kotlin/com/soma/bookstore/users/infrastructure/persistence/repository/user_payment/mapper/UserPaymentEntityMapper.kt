package com.soma.bookstore.users.infrastructure.persistence.repository.user_payment.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.infrastructure.persistence.entity.UserPaymentEntity
import org.springframework.stereotype.Component

@Component
class UserPaymentEntityMapper: Mapper<UserPaymentEntity, UserPayment>{

    override fun map(input: UserPayment): UserPaymentEntity {
        return UserPaymentEntity(
            input.id,
            input.name!!,
            input.creditNumber!!,
            input.expirationMonth!!,
            input.expirationYear!!,
            input.cvv!!,
            input.userId!!
        )
    }
}