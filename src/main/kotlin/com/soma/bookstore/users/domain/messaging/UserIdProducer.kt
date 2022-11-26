package com.soma.bookstore.users.domain.messaging

interface UserIdProducer {

    fun send(id: Long)
}