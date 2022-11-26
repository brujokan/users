package com.soma.bookstore.users.infrastructure.messaging.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.messaging.model.UserMessage
import org.springframework.stereotype.Component

@Component
class UserMessageMapper: Mapper<UserMessage, User> {

    override fun map(input: User): UserMessage {
        return UserMessage(
            id = input.id,
            name = input.name,
            surname = input.surname,
            secondSurname = input.secondSurname,
            email = input.email
        )
    }
}