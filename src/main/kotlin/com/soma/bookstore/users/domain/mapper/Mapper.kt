package com.soma.bookstore.users.domain.mapper

interface Mapper<T, V> {

    fun map(input: V): T
}