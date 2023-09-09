package com.namju.simple_todo.user.dto

/**
 * ȸ�� ���� ��
 * @property username �̸���
 * @property password ��� ��ȣ
 * @property nickname �г���
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
