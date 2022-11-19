package com.soma.bookstore.users.infrastructure.handler.user_address

import com.soma.bookstore.users.application.use_case.user_address.create.UserAddressCreateUseCase
import com.soma.bookstore.users.application.use_case.user_address.delete.AddressDeleteUseCase
import com.soma.bookstore.users.application.use_case.user_address.find.FindAddressUseCase
import com.soma.bookstore.users.application.use_case.user_address.find_by_user.FindAddressByUserUseCase
import com.soma.bookstore.users.application.use_case.user_address.update.UpdateAddressUseCase
import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.infrastructure.handler.user_address.request.UserAddressCreateRequest
import com.soma.bookstore.users.infrastructure.handler.user_address.request.UserAddressUpdateRequest
import com.soma.bookstore.users.infrastructure.handler.user_address.response.UserAddressResponse
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
@RequestMapping("/address")
class UserAddressController(
    private val addressCreateUseCase: UserAddressCreateUseCase,
    private val addressFindUseCase: FindAddressUseCase,
    private val addressFindAddressByUserUseCase: FindAddressByUserUseCase,
    private val addressUpdateUseCase: UpdateAddressUseCase,
    private val addressDeleteUseCase: AddressDeleteUseCase,
    private val requestCreateMapper: Mapper<UserAddress, UserAddressCreateRequest>,
    private val requestUpdateMapper: Mapper<UserAddress, UserAddressUpdateRequest>,
    private val responseMapper: Mapper<UserAddressResponse, UserAddress>
) {

    @Operation(
        summary = "Create new user address",
        description = "Create new user address",
        operationId = "create_address"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "User address successfully created"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @PostMapping
    fun create(@RequestBody payload: UserAddressCreateRequest): ResponseEntity<Void> {
        val address: UserAddress = addressCreateUseCase.create(
            requestCreateMapper.map(payload)
        )
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("../user/{user_id}")
            .buildAndExpand(address.userId).toUri()
        return ResponseEntity.created(uri).build()
    }

    @Operation(
        summary = "Find address by id",
        description = "Find address by id",
        operationId = "find"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Address successfully retrieved"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "Address not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: Long): ResponseEntity<UserAddressResponse> {
        return ResponseEntity.ok(responseMapper.map(addressFindUseCase.find(id)))
    }

    @Operation(
        summary = "Find addresses by user_id",
        description = "Find addresses by user_id",
        operationId = "findByUser"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Addresses successfully retrieved"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @GetMapping("/findByUser/{user_id}")
    fun findByUser(@PathVariable("user_id") userId: Long): ResponseEntity<List<UserAddressResponse>> {
        return ResponseEntity.ok(
            addressFindAddressByUserUseCase.findByUser(userId).map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Update user address",
        description = "Update user address",
        operationId = "update_address"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Address successfully updated"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "Address not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @PutMapping("{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody payload: UserAddressUpdateRequest): ResponseEntity<UserAddressResponse> {
        return ResponseEntity.ok(
            responseMapper.map(addressUpdateUseCase.update(id, requestUpdateMapper.map(payload)))
        )
    }

    @Operation(
        summary = "Delete user address",
        description = "Delete user address",
        operationId = "delete_address"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Address successfully deleted"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "Address not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: Long) = addressDeleteUseCase.delete(id)
}