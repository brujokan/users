package com.soma.bookstore.users.application.use_case.user.create

import com.soma.bookstore.users.domain.messaging.UserProducer
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class UserCreateUseCase(
    private val repository: UserRepository,
    private val userCreateProducer: UserProducer
    ) {

    fun save(user: User): User {
        val userSaved = repository.save(user)
        userCreateProducer.send(userSaved)

        return userSaved
    }
}