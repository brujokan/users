package com.soma.bookstore.users.application.use_case.user.delete

import com.soma.bookstore.users.domain.repository.UserAddressRepository
import com.soma.bookstore.users.domain.repository.UserPaymentRepository
import com.soma.bookstore.users.domain.repository.UserRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserDeleteUseCase(
    private val repository: UserRepository,
    private val addressRepository: UserAddressRepository,
    private val paymentRepository: UserPaymentRepository
) {
    fun delete(id: Long) {
        if (repository.existsById(id)) {
            addressRepository.findByUser(id).forEach { a -> addressRepository.delete(a.id!!) }
            paymentRepository.findByUser(id).forEach { p -> paymentRepository.delete(p.id!!) }

            repository.delete(id)
        } else throw NotFoundException("User with id ${id} not exists. Cannot delete")
    }
}