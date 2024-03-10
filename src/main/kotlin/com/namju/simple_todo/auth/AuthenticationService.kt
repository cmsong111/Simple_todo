package com.namju.simple_todo.auth

import com.namju.simple_todo.user.User
import com.namju.simple_todo.user.UserRepository
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
            throw RuntimeException("이미 존재하는 닉네임입니다.")
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
