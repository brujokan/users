package com.soma.bookstore.users

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition
@SpringBootApplication
class UsersApplication

fun main(args: Array<String>) {
	runApplication<UsersApplication>(*args)
}
