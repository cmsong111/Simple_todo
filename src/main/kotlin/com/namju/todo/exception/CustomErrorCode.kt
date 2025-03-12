package com.namju.todo.exception

import org.springframework.http.HttpStatus

enum class CustomErrorCode(val status: HttpStatus, val message: String) {
    ALREADY_EXIST_USER_ID(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디입니다."),
}
