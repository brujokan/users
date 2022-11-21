package com.soma.bookstore.users.infrastructure.persistence.repository.user.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.persistence.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserModelMapper: Mapper<User, UserEntity>{

    override fun map(input: UserEntity): User {
        return User(
            input.id,
            input.name,
            input.surname,
            input.secondSurname,
            input.email,
            input.password
        )
    }
}