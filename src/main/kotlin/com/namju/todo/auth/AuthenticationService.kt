package com.namju.todo.auth

import com.namju.todo.exception.CustomErrorCode
import com.namju.todo.exception.CustomException
import com.namju.todo.user.User
import com.namju.todo.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByUsername(username)
    }

    fun register(registerForm: RegisterForm): User {
        if (userRepository.existsByUsername(registerForm.username)) {
            throw CustomException(CustomErrorCode.ALREADY_EXIST_USER_ID)
        }
        return userRepository.save(
            User(
                username = registerForm.username,
                password = passwordEncoder.encode(registerForm.password),
                nickname = registerForm.nickname
            )
        )
    }
}
