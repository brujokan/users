package com.soma.bookstore.users.domain.repository

import com.soma.bookstore.users.domain.model.UserAddress

interface UserAddressRepository {

    fun save(userAddress: UserAddress): UserAddress

    fun update(userAddress: UserAddress): UserAddress

    fun find(id: Long): UserAddress?

    fun findByUser(userId: Long): List<UserAddress>

    fun delete(id: Long)

    fun existsById(id: Long): Boolean
}