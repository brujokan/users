package com.soma.bookstore.users.infrastructure.persistence.repository.user_address.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.infrastructure.persistence.entity.UserAddressEntity
import org.springframework.stereotype.Component

@Component
class UserAddressEntityMapper: Mapper<UserAddressEntity, UserAddress> {

    override fun map(input: UserAddress): UserAddressEntity {
        return UserAddressEntity(
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