package com.ermain.todotaskapi.backend.repository

import com.ermain.todotaskapi.backend.model.Todo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : MongoRepository<Todo, String> {
}