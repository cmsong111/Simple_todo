package com.namju.todo.auth

import com.namju.todo.user.User
import java.net.URI
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

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
