package com.soma.bookstore.users.application.use_case.user_payment.find

import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class FindPaymentUseCase(private val paymentRepository: UserPaymentRepository) {

    fun find(id: Long): UserPayment {
        return paymentRepository.find(id) ?: throw NotFoundException("Payment with id ${id} not found")
    }
}