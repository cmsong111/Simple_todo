package com.namju.todo.auth

data class RegisterForm(
    var username: String,
    var password: String,
    var nickname: String,
) {
    override fun toString(): String {
        return "RegisterForm(username='$username', password='$password', nickname='$nickname')"
    }
}
