package com.soma.bookstore.users.infrastructure.handler.user_payment.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UserPaymentResponse(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("credit_number")
    val creditNumber: Long,
    @JsonProperty("expiration_month")
    val expirationMonth: String,
    @JsonProperty("expiration_year")
    val expirationYear: String,
    @JsonProperty("cvv")
    val cvv: String,
    @JsonProperty("user_id")
    val userId: Long
)
