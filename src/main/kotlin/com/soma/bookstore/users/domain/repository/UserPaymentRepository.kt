package com.soma.bookstore.users.domain.repository

import com.soma.bookstore.users.domain.model.UserPayment

interface UserPaymentRepository {
    fun save(userPayment: UserPayment): UserPayment

    fun update(userPayment: UserPayment): UserPayment

    fun find(id: Long): UserPayment?

    fun findByUser(userId: Long): List<UserPayment>

    fun existsById(id: Long): Boolean

    fun delete(id: Long)
}