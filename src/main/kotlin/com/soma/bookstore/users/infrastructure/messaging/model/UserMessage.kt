package com.soma.bookstore.users.infrastructure.messaging.model

import com.fasterxml.jackson.annotation.JsonProperty

data class UserMessage(
    @JsonProperty("id")
    val id: Long? = null,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("surname")
    val surname: String,
    @JsonProperty("second_surname")
    val secondSurname: String?,
    @JsonProperty("email")
    val email: String
)
