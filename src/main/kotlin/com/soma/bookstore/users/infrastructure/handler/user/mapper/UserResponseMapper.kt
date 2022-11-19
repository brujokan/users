package com.soma.bookstore.users.infrastructure.handler.user.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.handler.user.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserResponseMapper: Mapper<UserResponse, User> {

    override fun map(input: User): UserResponse {
        return UserResponse(
            input.id!!,
            input.name,
            input.surname,
            input.secondSurname,
            input.email
        )
    }
}