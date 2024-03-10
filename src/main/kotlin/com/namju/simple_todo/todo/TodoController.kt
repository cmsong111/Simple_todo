package com.namju.simple_todo.todo

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
        model.addAttribute("username", principal.name)
        return "todo/todo"
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    fun addTodo(
        principal: Principal,
        todoForm: TodoForm
    ) : String {
        todoService.addTodo(
            username = principal.name,
            title = todoForm.title,
            content = todoForm.content
        )
        return "redirect:/todo"
    }
}
