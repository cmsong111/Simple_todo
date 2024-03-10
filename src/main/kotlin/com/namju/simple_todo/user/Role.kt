package com.namju.simple_todo.user

import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.security.Permission
import java.util.stream.Collectors

enum class Role {
    USER, ADMIN;

    private val permissions: Set<Permission> = emptySet()
    fun getAuthorities(): List<SimpleGrantedAuthority> {
        val authorities = permissions
            .stream()
            .map { permission -> SimpleGrantedAuthority(permission.name) }
            .collect(Collectors.toList())
        authorities.add(SimpleGrantedAuthority("ROLE_$name"))
        return authorities
    }
}
