package com.soma.bookstore.users.domain.model

data class User(
    val id: Long? = null,
    val name: String,
    val surname: String,
    val secondSurname: String?,
    val email: String,
    val password: String
)