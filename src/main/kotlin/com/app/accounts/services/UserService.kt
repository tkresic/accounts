package com.app.accounts.services

import com.app.accounts.models.User
import com.app.accounts.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * User service.
 */
@Service
class UserService(val db: UserRepository) {
    fun all(): MutableIterable<User> =
        db.findAll()

    fun save(user: User): User =
        db.save(user)

    fun read(id: Long): Optional<User> =
        db.findById(id)

    fun update(id: Long, user: User): ResponseEntity<User?> {
        val userData: Optional<User> = this.read(id)

        if (!userData.isPresent) {
            return ResponseEntity<User?>(HttpStatus.NOT_FOUND)
        }

        val updatedUser: User = userData.get()

        updatedUser.name = user.name

        return ResponseEntity<User?>(this.save(updatedUser), HttpStatus.OK)
    }

    fun delete(id: Long) =
        db.deleteById(id)
}