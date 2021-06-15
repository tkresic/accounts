package com.app.accounts.controllers

import com.app.accounts.models.User
import com.app.accounts.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * User controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/users")
class UserController(val service: UserService) {
    @GetMapping
    fun index(): MutableIterable<User> =
        service.all()

    @PostMapping
    fun create(@RequestBody user: User) =
        service.save(user)

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): Optional<User> =
        service.read(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User?> =
        service.update(id, user);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}