package com.namju.simple_todo.todo.controller

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/todo")
class TodoController {

    val log = LoggerFactory.getLogger(this::class.java)
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    fun todo(
        httpServletRequest: HttpServletRequest
    ): String {
        log.info("user: ${httpServletRequest.session.getAttribute("user")}")
        return "todo/todo"
    }


}
