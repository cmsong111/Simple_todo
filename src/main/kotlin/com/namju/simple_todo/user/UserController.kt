package com.namju.simple_todo.user

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.security.Principal


@Controller
class UserController(
    var userService: UserService,
) {

    @GetMapping("/register")
    fun register(): String {
        return "user/register"
    }

    @GetMapping("/account")
    fun account(
        model: Model,
        principal: Principal
    ): String {
        model.addAttribute("user", userService.getUser(principal.name))
        return "user/account"
    }

    @PostMapping("/account")
    fun account(
        model: Model,
        principal: Principal,
        nickname: String,
        password: String
    ): String {
        model.addAttribute("user", userService.updateUser(principal.name, nickname, password))
        return "user/account"
    }
}
