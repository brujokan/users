package com.soma.bookstore.users.application.use_case.user_payment.delete

import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class PaymentDeleteUseCase(
    private val paymentRepository: UserPaymentRepository
) {
    fun delete(id: Long) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.delete(id)
        } else throw NotFoundException("Payment with id ${id} not exists. Cannot delete")
    }
}