package com.app.accounts.services

import com.app.accounts.dtos.UserLoginDTO
import com.app.accounts.models.User
import com.app.accounts.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * User service.
 */
@Service
class LoginService(val db: UserRepository) {
    fun login(user: UserLoginDTO): ResponseEntity<User?> {
        val userData: User = db.findByUsername(user.username) ?: return ResponseEntity<User?>(HttpStatus.NOT_FOUND)
        return ResponseEntity<User?>(userData, HttpStatus.OK)
    }
}