package com.app.accounts.repositories

import com.app.accounts.models.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * User JPA repository.
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}