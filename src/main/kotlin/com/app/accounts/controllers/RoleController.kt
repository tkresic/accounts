package com.app.accounts.controllers

import com.app.accounts.models.Role
import com.app.accounts.services.RoleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * Role controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/roles")
class RoleController(val service: RoleService) {
    @GetMapping
    fun index(): MutableIterable<Role> =
        service.all()

    @PostMapping
    fun create(@RequestBody role: Role) =
        service.save(role)

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): Optional<Role> =
        service.read(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody role: Role): ResponseEntity<Role?> =
        service.update(id, role);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}