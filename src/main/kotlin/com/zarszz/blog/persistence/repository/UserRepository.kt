package com.zarszz.blog.persistence.repository

import com.zarszz.blog.persistence.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}
