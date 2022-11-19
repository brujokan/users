package com.soma.bookstore.users.infrastructure.persistence.repository.user.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.persistence.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserEntityMapper: Mapper<UserEntity, User> {

    override fun map(input: User): UserEntity {
        return UserEntity(
            input.id,
            input.name,
            input.surname,
            input.secondSurname,
            input.email,
            input.password
        )
    }
}