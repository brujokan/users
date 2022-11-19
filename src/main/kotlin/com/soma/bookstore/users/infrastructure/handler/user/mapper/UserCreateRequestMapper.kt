package com.soma.bookstore.users.infrastructure.handler.user.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.handler.user.request.UserCreateUserRequest
import org.springframework.stereotype.Component

@Component
class UserCreateRequestMapper: Mapper<User, UserCreateUserRequest> {

    override fun map(input: UserCreateUserRequest): User {
        return User(
            name = input.name,
            surname = input.surname,
            secondSurname = input.secondSurname,
            email = input.email,
            password = input.password
        )
    }
}