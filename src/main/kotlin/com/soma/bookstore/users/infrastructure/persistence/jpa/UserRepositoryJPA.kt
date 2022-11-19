package com.soma.bookstore.users.infrastructure.persistence.jpa

import com.soma.bookstore.users.infrastructure.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepositoryJPA: JpaRepository<UserEntity, Long>