package com.soma.bookstore.users.application.use_case.user_address.find_by_user

import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.domain.repository.UserAddressRepository
import org.springframework.stereotype.Service

@Service
class FindAddressByUserUseCase(
    private val addressRepository: UserAddressRepository
) {

    fun findByUser(userId: Long): List<UserAddress> {
        return addressRepository.findByUser(userId)
    }
}