package com.soma.bookstore.users.infrastructure.persistence.repository.user_address.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.infrastructure.persistence.entity.UserAddressEntity
import org.springframework.stereotype.Component

@Component
class UserAddressMapper: Mapper<UserAddress, UserAddressEntity> {

    override fun map(input: UserAddressEntity): UserAddress {
        return UserAddress(
            input.id,
            input.name!!,
            input.number!!,
            input.otherData,
            input.postalCode!!,
            input.provinceCode!!,
            input.countryCode!!,
            input.userId!!
        )
    }
}