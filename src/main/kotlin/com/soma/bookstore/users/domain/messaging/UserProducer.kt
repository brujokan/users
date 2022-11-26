package com.soma.bookstore.users.domain.messaging

import com.soma.bookstore.users.domain.model.User

interface UserProducer {

    fun send(user: User)
}