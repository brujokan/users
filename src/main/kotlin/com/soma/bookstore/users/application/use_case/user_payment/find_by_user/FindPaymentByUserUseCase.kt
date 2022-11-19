package com.soma.bookstore.users.application.use_case.user_payment.find_by_user

import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import org.springframework.stereotype.Service

@Service
class FindPaymentByUserUseCase(
    private val paymentRepository: UserPaymentRepository
) {
    fun findByUser(userId: Long): List<UserPayment> {
        return paymentRepository.findByUser(userId)
    }

}