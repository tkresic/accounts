package com.app.accounts.repositories

import com.app.accounts.models.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Role JPA repository.
 */
interface RoleRepository : JpaRepository<Role, Long>