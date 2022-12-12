package com.soma.bookstore.users.application.use_case.user.delete

import com.soma.bookstore.users.domain.messaging.UserIdProducer
import com.soma.bookstore.users.domain.repository.UserAddressRepository
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import com.soma.bookstore.users.domain.repository.UserRepository
import com.soma.bookstore.users.exception.NotFoundException
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class UserDeleteUseCase(
    private val repository: UserRepository,
    private val addressRepository: UserAddressRepository,
    private val paymentRepository: UserPaymentRepository,
    private val userIdProducer: UserIdProducer

) {

    private val logger = KotlinLogging.logger {  }
    fun delete(id: Long) {
        if (repository.existsById(id)) {
            addressRepository.findByUser(id).forEach { a -> addressRepository.delete(a.id!!) }
            paymentRepository.findByUser(id).forEach { p -> paymentRepository.delete(p.id!!) }

            repository.delete(id)

            try {
                userIdProducer.send(id)
            } catch (ex: Exception) {
                logger.error { "Error: ${ex.message}" }
            }

        } else throw NotFoundException("User with id ${id} not exists. Cannot delete")
    }
}