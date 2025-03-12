package com.namju.todo.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler(CustomException::class)
    protected fun handleBaseException(e: CustomException): ResponseEntity<CustomErrorResponse> {
        return ResponseEntity.status(e.customErrorCode.status)
            .body(CustomErrorResponse(e.customErrorCode.status, e.customErrorCode, e.customErrorCode.message))
    }
}
