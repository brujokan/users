package com.soma.bookstore.users.infrastructure.handler.user_payment.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

data class UserPaymentUpdateRequest(
    @field:Schema(required = true, description = "Id of the user")
    @NotNull(message = "Required")
    @JsonProperty("user_id")
    val userId: Long,
    @field:Schema(required = true, description = "Name that appears in the card")
    @NotNull(message = "Required")
    val name: String,
    @field:Schema(required = true, description = "Credit card number")
    @NotNull(message = "Required")
    @JsonProperty("credit_number")
    val creditNumber: Long,
    @field:Schema(required = true, description = "Expiration month of the card")
    @NotNull(message = "Required")
    @JsonProperty("expiration_month")
    val expirationMonth: String,
    @field:Schema(required = true, description = "Expiration year of the card")
    @NotNull(message = "Required")
    @JsonProperty("expiration_year")
    val expirationYear: String,
    @field:Schema(required = true, description = "CVV of the card")
    @NotNull(message = "Required")
    val cvv: String
)
