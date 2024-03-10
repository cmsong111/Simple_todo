package com.namju.simple_todo.user.service


import com.namju.simple_todo.user.dto.RegisterForm
import com.namju.simple_todo.user.entity.UserEntity
import com.namju.simple_todo.user.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    val log: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param username
     * @return UserDetails
     */
    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByUsername(username).apply {
            log.info("loadUserByUsername method called.\nuser: $this")
        }
    }

    /**
     * 회원가입 메소드
     *
     * @param registerForm 회원가입 폼
     * @return UserDetails 회원가입 성공시 UserDetails 반환
     */
    fun register(registerForm: RegisterForm): UserEntity {

        if (userRepository.existsByUsername(registerForm.username)) {
            throw Exception("이미 가입된 이메일입니다.")
        }

        return userRepository.save(
            UserEntity(
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
    fun getUser(username: String): UserEntity {
        return userRepository.findByUsername(username)
    }

    fun updateUser(username: String, nickname: String, password: String): UserEntity {
        userRepository.findByUsername(username).apply {
            this.nickname = nickname
            this.password = passwordEncoder.encode(password)
        }.let {
            userRepository.save(it)
            return it
        }
    }
}
