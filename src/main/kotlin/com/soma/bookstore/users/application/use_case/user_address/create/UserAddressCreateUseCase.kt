package com.soma.bookstore.users.application.use_case.user_address.create

import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.domain.repository.UserAddressRepository
import org.springframework.stereotype.Service

@Service
class UserAddressCreateUseCase(
    private val addressRepository: UserAddressRepository
) {

    fun create(userAddress: UserAddress): UserAddress {
        return addressRepository.save(userAddress)
    }
}