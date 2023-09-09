package com.namju.simple_todo.todo.controller

import com.namju.simple_todo.todo.service.TodoSerivce
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal

@Controller
@RequestMapping("/todo")
class TodoController(
    var todoService: TodoSerivce
) {
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    fun todo(
        principal: Principal,
        model: Model
    ): String {
        todoService.getTodoListByUsername(principal.name).apply {
            model.addAttribute("todoList", this)
        }
        return "todo/todo"
    }
}
