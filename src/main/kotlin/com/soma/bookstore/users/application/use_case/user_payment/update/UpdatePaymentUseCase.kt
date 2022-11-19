package com.soma.bookstore.users.application.use_case.user_payment.update

import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UpdatePaymentUseCase(
    private val paymentRepository: UserPaymentRepository
) {
    fun update(id: Long, payment: UserPayment): UserPayment {
        if (paymentRepository.existsById(id)) {
            return paymentRepository.update(
                UserPayment(
                    id,
                    payment.name,
                    payment.creditNumber,
                    payment.expirationMonth,
                    payment.expirationYear,
                    payment.cvv,
                    payment.userId
                )
            )
        } else throw NotFoundException("Payment with id ${id} not found. Cannot update")
    }
}