package com.namju.simple_todo.user

import com.namju.simple_todo.common.BaseEntity
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    // JVM - Kotlin 변환에 문제가 있어서 private 선언 후 getter, setter를 선언해줘야 함
    private var username: String,
    private var password: String,
    var nickname: String,
    @Enumerated(EnumType.STRING)
    var role: Role = Role.USER
) : BaseEntity(), UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return role.getAuthorities()
    }

    override fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    override fun getUsername(): String {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
        return true;
    }

    override fun toString(): String {
        return "UserEntity(idx=$id, username='$username', password='$password', nickname='$nickname')"
    }
}
