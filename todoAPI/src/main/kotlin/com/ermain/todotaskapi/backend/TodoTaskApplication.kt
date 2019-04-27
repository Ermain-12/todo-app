package com.ermain.todotaskapi.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoTaskApplication

fun main(args: Array<String>) {
    runApplication<TodoTaskApplication>(*args)
}
