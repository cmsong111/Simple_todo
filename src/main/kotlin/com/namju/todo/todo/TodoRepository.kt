package com.namju.todo.todo

import com.namju.todo.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {
    fun findByUser(user: User): List<Todo>


    fun findByUserOrderByIsDoneAsc(user: User): List<Todo>
}
