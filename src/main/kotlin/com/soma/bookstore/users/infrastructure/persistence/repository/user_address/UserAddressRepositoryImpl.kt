package com.soma.bookstore.users.infrastructure.persistence.repository.user_address

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.UserAddress
import com.soma.bookstore.users.domain.repository.UserAddressRepository
import com.soma.bookstore.users.infrastructure.persistence.entity.UserAddressEntity
import com.soma.bookstore.users.infrastructure.persistence.jpa.UserAddressRepositoryJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserAddressRepositoryImpl(
    private val jpaRepository: UserAddressRepositoryJPA,
    private val entityMapper: Mapper<UserAddressEntity, UserAddress>,
    private val modelMapper: Mapper<UserAddress, UserAddressEntity>
): UserAddressRepository {

    override fun save(userAddress: UserAddress): UserAddress {
        return modelMapper.map(jpaRepository.save(entityMapper.map(userAddress)))
    }

    override fun update(userAddress: UserAddress): UserAddress {
        return modelMapper.map(jpaRepository.save(entityMapper.map(userAddress)))
    }

    override fun find(id: Long): UserAddress? {
        return modelMapper.map(jpaRepository.findByIdOrNull(id) ?: return null)
    }

    override fun findByUser(userId: Long): List<UserAddress> {
        return jpaRepository.findByUserId(userId).map(modelMapper::map)
    }

    override fun delete(id: Long) = jpaRepository.deleteById(id)

    override fun existsById(id: Long): Boolean {
        return jpaRepository.existsById(id)
    }
}