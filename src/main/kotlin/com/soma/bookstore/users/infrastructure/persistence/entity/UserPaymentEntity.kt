package com.soma.bookstore.users.infrastructure.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "user_payment", schema = "user")
data class UserPaymentEntity(
    @Id
    @GeneratedValue(generator = "userPaymentSeq")
    @SequenceGenerator(name = "userPaymentSeq", sequenceName = "USER_PAYMENT_SEQUENCE", allocationSize = 1, schema = "user")
    val id: Long?,
    val name: String,
    @Column(name = "credit_number")
    val creditNumber: Long,
    @Column(name = "expiration_month")
    val expirationMonth: String,
    @Column(name = "expiration_year")
    val expirationYear: String,
    val cvv: String,
    @Column(name = "user_id")
    val userId: Long
)