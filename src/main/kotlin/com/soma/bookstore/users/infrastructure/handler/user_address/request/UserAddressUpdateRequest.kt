package com.soma.bookstore.users.infrastructure.handler.user_address.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

data class UserAddressUpdateRequest(
    @field:Schema(required = true, description = "Id of the user")
    @NotNull(message = "Required")
    @JsonProperty("user_id")
    val userId: Long,
    @field:Schema(required = true, description = "Name of the street where the user lives")
    @NotNull(message = "Required")
    @JsonProperty("name")
    val name: String,
    @field:Schema(required = true, description = "Number of the address of the user")
    @NotNull(message = "Required")
    @JsonProperty("number")
    val number: Integer,
    @field:Schema(required = false, description = "Other data like floor, door, ...")
    @JsonProperty("other_data")
    val otherData: String?,
    @field:Schema(required = true, description = "Postal code of the address")
    @JsonProperty("postal_code")
    @NotNull(message = "Required")
    val postalCode: String,
    @field:Schema(required = true, description = "Code of the provice where the address is")
    @NotNull(message = "Required")
    @JsonProperty("province_code")
    val provinceCode: String,
    @field:Schema(required = true, description = "Code of the country")
    @NotNull(message = "Required")
    @JsonProperty("country_code")
    val countryCode: String
)
