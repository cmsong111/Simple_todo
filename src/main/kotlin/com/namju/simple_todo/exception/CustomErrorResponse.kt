package com.namju.simple_todo.exception

import org.springframework.http.HttpStatus

class CustomErrorResponse(
    val status: HttpStatus,
    val errorType: CustomErrorCode,
    val message: String
)
