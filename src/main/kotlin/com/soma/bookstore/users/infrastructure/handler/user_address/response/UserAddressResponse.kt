package com.soma.bookstore.users.infrastructure.handler.user_address.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UserAddressResponse(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("number")
    val number: Integer,
    @JsonProperty("other_data")
    val otherData: String?,
    @JsonProperty("postal_code")
    val postalCode: String,
    @JsonProperty("province_code")
    val provinceCode: String,
    @JsonProperty("country_code")
    val countryCode: String,
    @JsonProperty("user_id")
    val userId: Long
)
