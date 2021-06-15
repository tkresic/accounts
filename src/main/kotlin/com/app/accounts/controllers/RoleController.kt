package com.app.accounts.controllers

import com.app.accounts.models.Role
import com.app.accounts.services.RoleService
import org.springframework.web.bind.annotation.*

/**
 * Role controller for CRUD methods.
 */
@RestController
@RequestMapping("/api/roles")
class RoleController(val service: RoleService) {
    @GetMapping
    fun index(): MutableIterable<Role> =
        service.all()
}