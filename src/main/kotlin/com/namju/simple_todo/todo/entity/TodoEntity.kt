package com.namju.simple_todo.todo.entity

import com.namju.simple_todo.user.entity.UserEntity
import jakarta.persistence.*

@Entity
class TodoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var title: String,
    var content: String,
    var isDone: Boolean = false,

    @ManyToOne(cascade = [CascadeType.ALL])
    var user: UserEntity,
) {
    override fun toString(): String {
        return "TodoEntity(id=$id, title='$title', content='$content', isDone=$isDone, user=${user.username})"
    }
}
