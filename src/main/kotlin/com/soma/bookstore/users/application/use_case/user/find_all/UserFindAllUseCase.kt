package com.soma.bookstore.users.application.use_case.user.find_all

import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserFindAllUseCase(
    private val repository: UserRepository
) {

    fun findAll():List<User>{
        return repository.findAll()
    }
}