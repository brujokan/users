package com.soma.bookstore.users.application.use_case.user.find

import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserFindUseCase(private val repository: UserRepository) {

    fun findById(id: Long): User {
        return repository.getById(id) ?: throw NotFoundException("User ${id} not found")
    }
}