package com.soma.bookstore.users.infrastructure.persistence.jpa

import com.soma.bookstore.users.infrastructure.persistence.entity.UserPaymentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserPaymentRepositoryJPA: JpaRepository<UserPaymentEntity, Long> {

    fun findByUserId(userId: Long): List<UserPaymentEntity>
}