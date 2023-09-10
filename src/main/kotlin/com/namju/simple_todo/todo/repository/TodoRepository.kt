package com.namju.simple_todo.todo.repository

import com.namju.simple_todo.todo.entity.TodoEntity
import com.namju.simple_todo.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<TodoEntity, Long> {
    fun findByUser(user: UserEntity): List<TodoEntity>


    fun findByUserOrderByIsDoneAsc(user: UserEntity): List<TodoEntity>
}
