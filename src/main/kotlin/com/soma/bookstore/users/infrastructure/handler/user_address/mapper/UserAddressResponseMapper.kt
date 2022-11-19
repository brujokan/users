package com.soma.bookstore.users.infrastructure.handler.user_address.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.infrastructure.handler.user_address.response.UserAddressResponse
import org.springframework.stereotype.Component

@Component
class UserAddressResponseMapper: Mapper<UserAddressResponse, UserAddress> {

    override fun map(input: UserAddress): UserAddressResponse {
        return UserAddressResponse(
            input.id!!,
            input.name,
            input.number,
            input.otherData,
            input.postalCode,
            input.provinceCode,
            input.countryCode,
            input.userId
        )
    }
}