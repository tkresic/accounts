package com.app.accounts.controllers

import com.app.accounts.dtos.UserLoginDTO
import com.app.accounts.models.User
import com.app.accounts.services.LoginService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Login controller.
 */
@RestController
@RequestMapping("/login")
class LoginController(val service: LoginService) {
    @PostMapping
    fun login(@RequestBody userLogin: UserLoginDTO): ResponseEntity<User?> =
        service.login(userLogin)
}