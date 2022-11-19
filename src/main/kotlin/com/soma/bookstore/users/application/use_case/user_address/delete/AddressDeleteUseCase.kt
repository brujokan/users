package com.soma.bookstore.users.application.use_case.user_address.delete

import com.soma.bookstore.users.domain.repository.UserAddressRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AddressDeleteUseCase(
    private val addressRepository: UserAddressRepository
) {
    fun delete(id: Long) {
        if (addressRepository.existsById(id)) {
            addressRepository.delete(id)
        }
        else throw NotFoundException("Address with id ${id} not exists. Cannot delete")
    }

}