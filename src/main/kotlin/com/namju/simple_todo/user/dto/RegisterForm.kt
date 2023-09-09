package com.namju.simple_todo.user.dto

/**
 * 회원 가입 폼
 * @property username 이메일
 * @property password 비밀 번호
 * @property nickname 닉네임
 */
data class RegisterForm(
    var username: String,
    var password: String,
    var nickname: String,
) {
    override fun toString(): String {
        return "RegisterForm(username='$username', password='$password', nickname='$nickname')"
    }
}
