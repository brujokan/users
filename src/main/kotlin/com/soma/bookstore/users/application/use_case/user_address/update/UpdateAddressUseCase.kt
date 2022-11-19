package com.soma.bookstore.users.application.use_case.user_address.update

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.domain.repository.UserAddressRepository
import com.soma.bookstore.users.exception.NotFoundException
import com.soma.bookstore.users.infrastructure.persistence.entity.UserAddressEntity
import org.springframework.stereotype.Service

@Service
class UpdateAddressUseCase(
    private val addressRepository: UserAddressRepository,
    private val modelMapper: Mapper<UserAddress, UserAddressEntity>,
    private val entityMapper: Mapper<UserAddressEntity, UserAddress>

) {
    fun update(id: Long, address: UserAddress): UserAddress {
        if (addressRepository.existsById(id)) {
            return addressRepository.update(
                UserAddress(
                    id,
                    address.name,
                    address.number,
                    address.otherData,
                    address.postalCode,
                    address.provinceCode,
                    address.countryCode,
                    address.userId
                )
            )
        } else throw NotFoundException("Address with id ${id} not found. Cannot update")
    }
}