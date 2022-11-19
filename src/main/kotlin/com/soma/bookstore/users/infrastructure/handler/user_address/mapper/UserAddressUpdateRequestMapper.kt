package com.soma.bookstore.users.infrastructure.handler.user_address.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.infrastructure.handler.user_address.request.UserAddressCreateRequest
import com.soma.bookstore.users.infrastructure.handler.user_address.request.UserAddressUpdateRequest
import org.springframework.stereotype.Component

@Component
class UserAddressUpdateRequestMapper: Mapper<UserAddress, UserAddressUpdateRequest> {

    override fun map(input: UserAddressUpdateRequest): UserAddress {
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