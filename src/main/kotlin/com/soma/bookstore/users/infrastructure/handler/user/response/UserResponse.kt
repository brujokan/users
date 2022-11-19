package com.soma.bookstore.users.infrastructure.handler.user.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
    @JsonProperty("id")
    val id:Long,
    @JsonProperty("name")
    val name:String,
    @JsonProperty("surname")
    val surname:String,
    @JsonProperty("second_surname")
    val secondSurname:String?,
    @JsonProperty("email")
    val email:String
)