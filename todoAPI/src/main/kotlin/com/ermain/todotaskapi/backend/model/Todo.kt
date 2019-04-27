package com.ermain.todotaskapi.backend.model

import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.Id
import javax.annotation.Generated
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Document(collection = "todos")
@Getter
@Setter
data class Todo(@Id
                @Generated
                val id: String = UUID.randomUUID().toString(),
                @NotBlank
                @Size(max=150)
                @Indexed(unique=true)
                val title: String,
                val isCompleted: String)