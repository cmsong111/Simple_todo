package com.namju.simple_todo.todo.service

import com.namju.simple_todo.todo.entity.TodoEntity
import com.namju.simple_todo.todo.repository.TodoRepository
import com.namju.simple_todo.user.entity.UserEntity
import com.namju.simple_todo.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TodoSerivce(
    var todoRepository: TodoRepository,
    var userRepository: UserRepository
) {
   val log = LoggerFactory.getLogger(this::class.java)
    /**
     * 유저 아이디로 Todo 리스트 조회
     * @param userId 유저 아이디
     * @return List<TodoEntity> Todo 리스트
     */
    fun getTodoListByUsername(username: String): List<TodoEntity> {
        val user: UserEntity = userRepository.findByUsername(username)
        return todoRepository.findByUserOrderByIsDoneAsc(user)
    }

    /**
     * Todo 추가
     * @param username 유저 아이디
     * @param title Todo 제목
     * @param content Todo 내용
     */
    fun addTodo(
        username: String,
        title: String,
        content: String
    ) {
        val user: UserEntity = userRepository.findByUsername(username)
        todoRepository.save(
            TodoEntity(
                title = title,
                content = content,
                user = user
            )
        )
    }

    fun changeDone(
        todoId: Long
    ) {
        val todo: TodoEntity = todoRepository.findById(todoId).get()
        todo.isDone = !todo.isDone
        log.info(todoRepository.save(todo).toString());
    }
}
