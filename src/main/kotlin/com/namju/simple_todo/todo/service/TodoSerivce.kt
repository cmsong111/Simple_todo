package com.namju.simple_todo.todo.service

import com.namju.simple_todo.todo.entity.TodoEntity
import com.namju.simple_todo.todo.repository.TodoRepository
import com.namju.simple_todo.user.entity.UserEntity
import com.namju.simple_todo.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class TodoSerivce(
    var todoRepository: TodoRepository,
    var userRepository: UserRepository
) {
    /**
     * 유저 아이디로 Todo 리스트 조회
     * @param userId 유저 아이디
     * @return List<TodoEntity> Todo 리스트
     */
    fun getTodoListByUsername(username: String): List<TodoEntity> {
        val user: UserEntity = userRepository.findByUsername(username)
        return todoRepository.findByUser(user)
    }
}
