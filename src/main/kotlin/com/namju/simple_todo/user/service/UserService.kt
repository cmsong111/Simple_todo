package com.namju.simple_todo.user.service


import com.namju.simple_todo.user.dto.RegisterForm
import com.namju.simple_todo.user.entity.UserEntity
import com.namju.simple_todo.user.repository.UserRepository
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

    val log = LoggerFactory.getLogger(this::class.java)

    /**
     * Spring Security �ʼ� �޼ҵ� ����
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
     * ȸ������ �޼ҵ�
     *
     * @param registerForm ȸ������ ��
     * @return UserDetails ȸ������ ������ UserDetails ��ȯ
     */
    fun register(registerForm: RegisterForm): UserEntity {

        if (userRepository.existsByUsername(registerForm.username)) {
            throw Exception("�̹� ���Ե� �̸����Դϴ�.")
        }

        return userRepository.save(
            UserEntity(
                username = registerForm.username,
                password = passwordEncoder.encode(registerForm.password),
                nickname = registerForm.nickname,
            )
        )
    }
}
