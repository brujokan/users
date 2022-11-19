package com.soma.bookstore.users.domain.repository

import com.soma.bookstore.users.domain.model.User

interface UserRepository {

    fun save(user:User): User

    fun getById(id:Long): User?

    fun findAll(): List<User>

    fun update(user: User): User

    fun delete(id: Long)

    fun existsById(id: Long): Boolean
}