package com.namju.simple_todo.user


import com.namju.simple_todo.auth.RegisterForm
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    /**
     * 회원가입 메소드
     *
     * @param registerForm 회원가입 폼
     * @return UserDetails 회원가입 성공시 UserDetails 반환
     */
    fun register(registerForm: RegisterForm): User {

        if (userRepository.existsByUsername(registerForm.username)) {
            throw Exception("이미 가입된 이메일입니다.")
        }

        return userRepository.save(
            User(
                username = registerForm.username,
                password = passwordEncoder.encode(registerForm.password),
                nickname = registerForm.nickname,
            )
        )
    }

    /**
     * 회원정보 불러오기 메소드
     *
     * @param username 회원정보를 불러올 회원의 username
     * @return UserEntity 회원정보
     */
    fun getUser(username: String): User {
        return userRepository.findByUsername(username)
    }

    fun updateUser(username: String, nickname: String, password: String): User {
        userRepository.findByUsername(username).apply {
            this.nickname = nickname
            this.password = passwordEncoder.encode(password)
        }.let {
            userRepository.save(it)
            return it
        }
    }
}
