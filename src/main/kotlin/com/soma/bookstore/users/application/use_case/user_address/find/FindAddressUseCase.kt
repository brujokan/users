package com.soma.bookstore.users.application.use_case.user_address.find

import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.domain.repository.UserAddressRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class FindAddressUseCase(private val addressRepository: UserAddressRepository) {

    fun find(id: Long): UserAddress {
        return addressRepository.find(id) ?: throw NotFoundException("Address with id ${id} not found")
    }
}