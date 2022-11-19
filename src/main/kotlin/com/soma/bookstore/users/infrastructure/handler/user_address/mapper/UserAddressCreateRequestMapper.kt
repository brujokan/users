package com.soma.bookstore.users.infrastructure.handler.user_address.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.infrastructure.handler.user_address.request.UserAddressCreateRequest
import org.springframework.stereotype.Component

@Component
class UserAddressCreateRequestMapper: Mapper<UserAddress, UserAddressCreateRequest> {

    override fun map(input: UserAddressCreateRequest): UserAddress {
        return UserAddress(
            name = input.name,
            number = input.number,
            otherData = input.otherData,
            postalCode = input.postalCode,
            provinceCode = input.provinceCode,
            countryCode = input.countryCode,
            userId = input.userId
        )
    }
}