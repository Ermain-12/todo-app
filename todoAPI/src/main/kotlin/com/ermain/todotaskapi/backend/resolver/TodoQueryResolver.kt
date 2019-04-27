package com.ermain.todotaskapi.backend.resolver

import com.ermain.todotaskapi.backend.model.Todo
import com.ermain.todotaskapi.backend.repository.TodoRepository
import org.springframework.data.mongodb.core.MongoOperations

class TodoQueryResolver(val todoRepository: TodoRepository,
                        private val mongoOperations: MongoOperations) {

    fun getTodos(): List<Todo> {
        val todoList = todoRepository.findAll()
        
        return todoList
    }
}