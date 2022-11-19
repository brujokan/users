package com.soma.bookstore.users.infrastructure.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "user", schema = "user")
data class UserEntity(
    @Id
    @GeneratedValue(generator = "userSeq")
    @SequenceGenerator(name = "userSeq", sequenceName = "USER_SEQUENCE", allocationSize = 1, schema = "user")
    val id: Long?,
    val name: String,
    val surname: String,
    @Column(name = "second_surname")
    val secondSurname: String?,
    val email: String,
    val password: String
)