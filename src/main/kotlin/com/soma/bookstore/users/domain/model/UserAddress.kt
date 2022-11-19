package com.soma.bookstore.users.domain.model

data class UserAddress(
    val id: Long? = null,
    val name: String,
    val number: Integer,
    val otherData: String?,
    val postalCode: String,
    val provinceCode: String,
    val countryCode: String,
    val userId: Long
)