package com.soma.bookstore.users.domain.model

data class UserPayment(
    val id: Long? = null,
    val name: String,
    val creditNumber: Long,
    val expirationMonth: String,
    val expirationYear: String,
    val cvv: String,
    val userId: Long
)