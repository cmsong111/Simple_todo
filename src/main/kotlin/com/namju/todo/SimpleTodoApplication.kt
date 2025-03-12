package com.namju.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class SimpleTodoApplication

fun main(args: Array<String>) {
    runApplication<SimpleTodoApplication>(*args)
}
