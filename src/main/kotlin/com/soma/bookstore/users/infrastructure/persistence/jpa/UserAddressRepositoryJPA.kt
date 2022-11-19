package com.soma.bookstore.users.infrastructure.persistence.jpa

import com.soma.bookstore.users.infrastructure.persistence.entity.UserAddressEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserAddressRepositoryJPA: JpaRepository<UserAddressEntity, Long> {

    fun findByUserId(id: Long): List<UserAddressEntity>
}