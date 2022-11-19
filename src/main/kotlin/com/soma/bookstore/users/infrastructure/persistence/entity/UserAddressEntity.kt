package com.soma.bookstore.users.infrastructure.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "user_address", schema = "user")
data class UserAddressEntity(
    @Id
    @GeneratedValue(generator = "userAddressSeq")
    @SequenceGenerator(name = "userAddressSeq", sequenceName = "USER_ADDRESS_SEQUENCE", allocationSize = 1, schema = "user")
    val id: Long?,
    val name: String,
    val number: Integer,
    @Column(name = "other_data")
    val otherData: String?,
    @Column(name = "postal_code")
    val postalCode: String,
    @Column(name = "province_code")
    val provinceCode: String,
    @Column(name = "country_code")
    val countryCode: String,
    @Column(name = "user_id")
    val userId: Long
)