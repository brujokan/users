package com.soma.bookstore.users.infrastructure.handler.user

import com.soma.bookstore.users.application.use_case.user.create.UserCreateUseCase
import com.soma.bookstore.users.application.use_case.user.delete.UserDeleteUseCase
import com.soma.bookstore.users.application.use_case.user.find.UserFindUseCase
import com.soma.bookstore.users.application.use_case.user.find_all.UserFindAllUseCase
import com.soma.bookstore.users.application.use_case.user.update.UserUpdateUseCase
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.handler.user.mapper.UserCreateRequestMapper
import com.soma.bookstore.users.infrastructure.handler.user.mapper.UserResponseMapper
import com.soma.bookstore.users.infrastructure.handler.user.mapper.UserUpdateRequestMapper
import com.soma.bookstore.users.infrastructure.handler.user.request.UserCreateUserRequest
import com.soma.bookstore.users.infrastructure.handler.user.request.UserUpdateRequest
import com.soma.bookstore.users.infrastructure.handler.user.response.UserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/user")
class UserController(
    private val userCreateUseCase: UserCreateUseCase,
    private val userFindUseCase: UserFindUseCase,
    private val userFindAllUseCase: UserFindAllUseCase,
    private val userUpdateUseCase: UserUpdateUseCase,
    private val userDeleteUseCase: UserDeleteUseCase,
    private val userCreateRequestMapper: UserCreateRequestMapper,
    private val userUpdateRequestMapper: UserUpdateRequestMapper,
    private val userResponseMapper: UserResponseMapper
) {

    @Operation(
        summary = "Create new user",
        description = "Create new user",
        operationId = "create"
    )
    @ApiResponses(value = [
       ApiResponse(responseCode = "201", description = "User successfully created"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @PostMapping
    fun create(@RequestBody payload: UserCreateUserRequest): ResponseEntity<Void> {
        val user: User = userCreateUseCase.save(userCreateRequestMapper.map(payload))
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{user_id}")
            .buildAndExpand(user.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @Operation(
        summary = "Find user by id",
        description = "Find user by id",
        operationId = "find"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "User successfully retrieved"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "User not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @GetMapping("/{user_id}")
    fun findById(@PathVariable("user_id") id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userResponseMapper.map(userFindUseCase.findById(id)))
    }

    @Operation(
        summary = "Find all users",
        description = "Find all users",
        operationId = "find all"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Users successfully retrieved"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @GetMapping
    fun findAll(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity.ok(
            userFindAllUseCase.findAll().map(userResponseMapper::map)
        )
    }

    @Operation(
        summary = "Update user",
        description = "Update user",
        operationId = "update"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "User successfully updated"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "User not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @PutMapping("/{user_id}")
    fun update(@PathVariable("user_id") id: Long, @RequestBody payload: UserUpdateRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(
            userResponseMapper.map(userUpdateUseCase.update(id, userUpdateRequestMapper.map(payload)))
        )
    }

    @Operation(
        summary = "Delete user",
        description = "Delete user",
        operationId = "delete"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "User successfully deleted"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "User not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = userDeleteUseCase.delete(id)
}