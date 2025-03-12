package com.namju.todo.todo

import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/todo")
class TodoAPIController(
    var todoService: TodoSerivce
) {

    @PatchMapping("/{id}")
    fun updateTodo(
        @PathVariable id: Long,
        principal: Principal
    ): ResponseEntity<String> {
        val username = principal.name

        todoService.changeDone(id)
        return ResponseEntity.ok("업데이트 완료")
    }
}
