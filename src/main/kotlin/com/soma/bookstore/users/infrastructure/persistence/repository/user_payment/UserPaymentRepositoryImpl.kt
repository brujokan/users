package com.soma.bookstore.users.infrastructure.persistence.repository.user_payment

import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import com.soma.bookstore.users.infrastructure.persistence.jpa.UserPaymentRepositoryJPA
import com.soma.bookstore.users.infrastructure.persistence.repository.user_payment.mapper.UserPaymentEntityMapper
import com.soma.bookstore.users.infrastructure.persistence.repository.user_payment.mapper.UserPaymentMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserPaymentRepositoryImpl(
    private val paymentRepository: UserPaymentRepositoryJPA,
    private val entityMapper: UserPaymentEntityMapper,
    private val modelMapper: UserPaymentMapper
): UserPaymentRepository {

    override fun save(userPayment: UserPayment): UserPayment {
        return modelMapper.map(
            paymentRepository.save(entityMapper.map(userPayment))
        )
    }

    override fun update(userPayment: UserPayment): UserPayment {
        return modelMapper.map(paymentRepository.save(entityMapper.map(userPayment)))
    }

    override fun find(id: Long): UserPayment? {
        return modelMapper.map(paymentRepository.findByIdOrNull(id) ?: return null)
    }

    override fun findByUser(userId: Long): List<UserPayment> {
        return paymentRepository.findByUserId(userId).map(modelMapper::map)
    }

    override fun existsById(id: Long): Boolean {
        return paymentRepository.existsById(id)
    }

    override fun delete(id: Long) = paymentRepository.deleteById(id)
}