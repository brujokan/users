package com.soma.bookstore.users.infrastructure.handler.user.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

@Schema(description = "User creation request")
data class UserCreateUserRequest(
    @field:Schema(required = true, description = "Name of the user")
    @NotNull(message = "Required")
    @JsonProperty("name")
    val name: String,
    @field:Schema(required = true, description = "Surname of the user")
    @NotNull(message = "Required")
    @JsonProperty("surname")
    val surname: String,
    @field:Schema(name = "second_surname", required = false, description = "Second surname of the user")
    @JsonProperty("second_surname")
    val secondSurname: String?,
    @field:Schema(required = true, description = "Email of the user")
    @NotNull(message = "Required")
    @JsonProperty("email")
    val email: String,
    @field:Schema(required = true, description = "Password of the user")
    @NotNull(message = "Required")
    @JsonProperty("password")
    val password: String
) {


}