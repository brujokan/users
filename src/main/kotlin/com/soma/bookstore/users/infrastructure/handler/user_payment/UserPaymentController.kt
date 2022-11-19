package com.soma.bookstore.users.infrastructure.handler.user_payment

import com.soma.bookstore.users.application.use_case.user_payment.create.UserPaymentCreateUseCase
import com.soma.bookstore.users.application.use_case.user_payment.delete.PaymentDeleteUseCase
import com.soma.bookstore.users.application.use_case.user_payment.find.FindPaymentUseCase
import com.soma.bookstore.users.application.use_case.user_payment.find_by_user.FindPaymentByUserUseCase
import com.soma.bookstore.users.application.use_case.user_payment.update.UpdatePaymentUseCase
import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserPayment
import com.soma.bookstore.users.infrastructure.handler.user_payment.request.UserPaymentCreateRequest
import com.soma.bookstore.users.infrastructure.handler.user_payment.request.UserPaymentUpdateRequest
import com.soma.bookstore.users.infrastructure.handler.user_payment.response.UserPaymentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/payment")
class UserPaymentController(
    private val paymentCreateUseCase: UserPaymentCreateUseCase,
    private val paymentFindUseCase: FindPaymentUseCase,
    private val paymentFindByUserUseCase: FindPaymentByUserUseCase,
    private val paymentUpdateUseCase: UpdatePaymentUseCase,
    private val paymentDeleteUseCase: PaymentDeleteUseCase,
    private val createRequestMapper: Mapper<UserPayment, UserPaymentCreateRequest>,
    private val updateRequestMapper: Mapper<UserPayment, UserPaymentUpdateRequest>,
    private val responseMapper: Mapper<UserPaymentResponse, UserPayment>
) {

    @Operation(
        summary = "Create new user payment",
        description = "Create new user payment",
        operationId = "create_payment"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "User payment successfully created"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PostMapping
    fun create(@RequestBody payload: UserPaymentCreateRequest): ResponseEntity<Void> {
        val payment: UserPayment = paymentCreateUseCase.create(
            createRequestMapper.map(payload)
        )
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("../user/{user_id}")
            .buildAndExpand(payment.userId).toUri()
        return ResponseEntity.created(uri).build()
    }

    @Operation(
        summary = "Find payment by id",
        description = "Find payment by id",
        operationId = "find"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Payment successfully retrieved"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Payment not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<UserPaymentResponse> {
        return ResponseEntity.ok(responseMapper.map(paymentFindUseCase.find(id)))
    }

    @Operation(
        summary = "Find payments by user_id",
        description = "Find payment by user_id",
        operationId = "findByUser"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Payment successfully retrieved"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/findByUser/{userId}")
    fun findByUser(@PathVariable("userId") userId: Long): ResponseEntity<List<UserPaymentResponse>> {
        return ResponseEntity.ok(
            paymentFindByUserUseCase.findByUser(userId).map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Update user payment",
        description = "Update user payment",
        operationId = "update_payment"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Payment successfully updated"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Payment not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody payload: UserPaymentUpdateRequest):
            ResponseEntity<UserPaymentResponse> {
        return ResponseEntity.ok(
            responseMapper.map(
                paymentUpdateUseCase.update(id, updateRequestMapper.map(payload))
            )
        )
    }

    @Operation(
        summary = "Delete user payment",
        description = "Delete user payment",
        operationId = "delete_payment"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Payment successfully deleted"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "Payment not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: Long) = paymentDeleteUseCase.delete(id)
}