package com.namju.simple_todo.auth

import com.namju.simple_todo.user.User
import org.springframework.http.ResponseEntity

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.net.URI

@Controller
@RequestMapping("/auth")
class AuthenticationController(
    val authenticationService: AuthenticationService
) {

    @GetMapping("/register")
    fun register(): String {
        return "auth/register"
    }

    @ResponseBody
    @PostMapping("/register")
    fun register(@RequestBody registerForm: RegisterForm): ResponseEntity<User> {
        val user: User = authenticationService.register(registerForm)
        return ResponseEntity.created(URI.create("/users/${user.id}")).body(user)
    }

}
