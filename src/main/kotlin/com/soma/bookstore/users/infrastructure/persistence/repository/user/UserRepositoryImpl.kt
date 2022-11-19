package com.soma.bookstore.users.infrastructure.persistence.repository.user

import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.domain.repository.UserRepository
import com.soma.bookstore.users.infrastructure.persistence.entity.UserEntity
import com.soma.bookstore.users.infrastructure.persistence.jpa.UserRepositoryJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val repository: UserRepositoryJPA,
    private val entityMapper: Mapper<UserEntity, User>,
    private val modelMapper: Mapper<User, UserEntity>
) : UserRepository {

    override fun save(user: User): User {
        return modelMapper.map(repository.save(entityMapper.map(user)))
    }

    override fun getById(id: Long): User? {
        return modelMapper.map(repository.findByIdOrNull(id) ?: return null)
    }

    override fun findAll(): List<User> {
        return repository.findAll().map(modelMapper::map)
    }

    override fun update(user: User): User {
        return modelMapper.map(
            repository.save(entityMapper.map(user))
        )
    }

    override fun delete(id: Long) = repository.deleteById(id)

    override fun existsById(id: Long): Boolean {
        return repository.existsById(id)
    }
}