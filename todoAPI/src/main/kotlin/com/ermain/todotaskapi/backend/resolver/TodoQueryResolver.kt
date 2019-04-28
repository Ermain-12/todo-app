package com.ermain.todotaskapi.backend.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.ermain.todotaskapi.backend.model.Todo
import com.ermain.todotaskapi.backend.repository.TodoRepository
import org.springframework.data.mongodb.core.MongoOperations
import java.util.*

class TodoQueryResolver(val todoRepository: TodoRepository,
                        private val mongoOperations: MongoOperations): GraphQLQueryResolver {

    fun getTodos(): List<Todo> {
        val todoList = todoRepository.findAll()

        return todoList
    }

    fun getTodo(id: String): Optional<Todo> {
        val todo = todoRepository.findById(id)
        return todo
    }
}