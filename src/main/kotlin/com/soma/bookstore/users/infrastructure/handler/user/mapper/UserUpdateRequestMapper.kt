package com.soma.bookstore.users.infrastructure.handler.user.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.handler.user.request.UserUpdateRequest
import org.springframework.stereotype.Component

@Component
class UserUpdateRequestMapper: Mapper<User, UserUpdateRequest> {

    override fun map(input: UserUpdateRequest): User {
        return User(
            name = input.name,
            surname = input.surname,
            secondSurname = input.secondSurname,
            email = input.email,
            password = input.password
        )
    }

}