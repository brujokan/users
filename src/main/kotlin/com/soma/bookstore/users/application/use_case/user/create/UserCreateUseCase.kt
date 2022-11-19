package com.soma.bookstore.users.application.use_case.user.create

import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateUseCase(private val repository: UserRepository) {

    fun save(user: User): User {
        return repository.save(user)
    }
}