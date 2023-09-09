package com.namju.simple_todo.user.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class UserController() {

    @GetMapping("/register")
    fun register(): String {
        return "user/register"
    }
}
