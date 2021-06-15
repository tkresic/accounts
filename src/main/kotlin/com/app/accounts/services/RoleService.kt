package com.app.accounts.services

import com.app.accounts.models.Role
import com.app.accounts.repositories.RoleRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * Role service.
 */
@Service
class RoleService(val db: RoleRepository) {
    fun all(): MutableIterable<Role> =
        db.findAll()

    fun save(role: Role): Role =
        db.save(role)

    fun read(id: Long): Optional<Role> =
        db.findById(id)

    fun update(id: Long, role: Role): ResponseEntity<Role?> {
        val roleData: Optional<Role> = this.read(id)

        if (!roleData.isPresent) {
            return ResponseEntity<Role?>(HttpStatus.NOT_FOUND)
        }

        val updatedRole: Role = roleData.get()

        updatedRole.name = role.name

        return ResponseEntity<Role?>(this.save(updatedRole), HttpStatus.OK)
    }

    fun delete(id: Long) =
        db.deleteById(id)
}