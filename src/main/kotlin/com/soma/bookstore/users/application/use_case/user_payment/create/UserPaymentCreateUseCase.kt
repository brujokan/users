package com.soma.bookstore.users.application.use_case.user_payment.create

import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import org.springframework.stereotype.Service

@Service
class UserPaymentCreateUseCase(
    private val paymentRepository: UserPaymentRepository
) {

    fun create(userPayment: UserPayment): UserPayment {
        return paymentRepository.save(userPayment)
    }
}