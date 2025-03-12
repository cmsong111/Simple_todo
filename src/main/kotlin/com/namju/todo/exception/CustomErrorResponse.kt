package com.namju.todo.exception

import org.springframework.http.HttpStatus

class CustomErrorResponse(
    val status: HttpStatus,
    val errorType: CustomErrorCode,
    val message: String
)
