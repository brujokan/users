package com.soma.bookstore.users.application.use_case.user.create

import com.soma.bookstore.users.domain.messaging.UserProducer
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class UserCreateUseCase(
    private val repository: UserRepository,
    private val userCreateProducer: UserProducer
    ) {

    private val logger = KotlinLogging.logger {  }

    fun save(user: User): User {
        val userSaved = repository.save(user)
        try {
            userCreateProducer.send(userSaved)
        } catch (ex: Exception) {
            logger.error { "Error: ${ex.message}" }
        }
        return userSaved
    }
}