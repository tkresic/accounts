package com.app.accounts.seeds

import com.app.accounts.models.User
import com.app.accounts.models.Role
import com.app.accounts.repositories.UserRepository
import com.app.accounts.repositories.RoleRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * Database seeder.
 */
@Component
class DatabaseSeeder(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        // Roles
        val roles = roleRepository.findAll()
        if (roles.size <= 0) {
            roleRepository.save(
                Role(
                    id = 1,
                    name = "Administrator",
                )
            )
        }
        // Users
        val users = userRepository.findAll()
        if (users.size <= 0) {
            userRepository.save(
                User(
                    id = 1,
                    username = "tkresic",
                    name = "Toni",
                    surname = "Krešić",
                    email = "tonikresic1997@gmail.com",
                    role = roles[0]
                )
            )
        }
    }
} 