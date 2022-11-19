package com.soma.bookstore.users.application.use_case.user.update

import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import com.soma.bookstore.users.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserUpdateUseCase(
    private val userRepository: UserRepository
) {

    fun update(id: Long, user: User): User {
        if (userRepository.existsById(id)) {
            return userRepository.update(
                User(
                    id = id,
                    name = user.name,
                    surname = user.surname,
                    secondSurname = user.secondSurname,
                    email = user.email,
                    password = user.password
                )
            )
        }
        throw NotFoundException("User with ${id} not exist. Cannot update")
    }
}