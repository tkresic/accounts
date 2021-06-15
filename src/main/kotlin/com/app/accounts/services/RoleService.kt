package com.app.accounts.services

import com.app.accounts.models.Role
import com.app.accounts.repositories.RoleRepository
import org.springframework.stereotype.Service

/**
 * Role service.
 */
@Service
class RoleService(val db: RoleRepository) {
    fun all(): MutableIterable<Role> =
        db.findAll()
}