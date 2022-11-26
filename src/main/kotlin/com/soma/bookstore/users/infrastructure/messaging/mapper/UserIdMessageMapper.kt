package com.soma.bookstore.users.infrastructure.messaging.mapper

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.infrastructure.messaging.model.UserIdMessage
import org.springframework.stereotype.Component

@Component
class UserIdMessageMapper: Mapper<UserIdMessage, Long> {

    override fun map(input: Long): UserIdMessage {
        return UserIdMessage(input)
    }
}