package com.namju.simple_todo.user.controller

import com.namju.simple_todo.user.dto.RegisterForm
import com.namju.simple_todo.user.entity.UserEntity
import com.namju.simple_todo.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserAPIController(
    var userService: UserService,
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/register")
    fun register(
        @RequestBody registerForm: RegisterForm
    ): UserEntity {
        log.info("registerForm: $registerForm")
        return userService.register(registerForm)
    }
}
