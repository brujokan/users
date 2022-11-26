package com.soma.bookstore.users.infrastructure.messaging.model

import com.fasterxml.jackson.annotation.JsonProperty

data class UserIdMessage(
    @JsonProperty("id")
    val id: Long
)