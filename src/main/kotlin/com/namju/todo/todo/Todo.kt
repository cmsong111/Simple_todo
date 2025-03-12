package com.namju.todo.todo

import com.namju.todo.user.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var title: String,
    var content: String,
    var isDone: Boolean = false,

    @ManyToOne(cascade = [CascadeType.ALL])
    var user: User,
) {
    override fun toString(): String {
        return "TodoEntity(id=$id, title='$title', content='$content', isDone=$isDone, user=${user.username})"
    }
}
