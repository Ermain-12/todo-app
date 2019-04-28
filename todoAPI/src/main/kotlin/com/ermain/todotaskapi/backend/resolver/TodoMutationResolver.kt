package com.ermain.todotaskapi.backend.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.ermain.todotaskapi.backend.model.Todo
import com.ermain.todotaskapi.backend.repository.TodoRepository

class TodoMutationResolver(private val todoRepository: TodoRepository): GraphQLMutationResolver {

    fun newTodo(todoTitle: String, isCompletedTodo: String): Todo {
        val todo = Todo(title = todoTitle, isCompleted = isCompletedTodo)
        todoRepository.save(todo)
        return todo
    }

    fun editTodo(id: String, todoTitle: String, isCompletedTodo: String): Todo {
        val todo = todoRepository.findById(id)

        todo.ifPresent {
            it.title = todoTitle
            it.isCompleted = isCompletedTodo
            todoRepository.save(it)
        }
        
        return todo.get()
    }

    fun deleteTodo(id: String): Boolean {
        todoRepository.deleteById(id)
        return true
    }
}