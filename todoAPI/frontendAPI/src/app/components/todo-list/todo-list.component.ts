import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todos: Todo[];
  newTodo: Todo = new Todo();
  editing = false;
  editingTodo: Todo = new Todo();

  constructor(private readonly todoService: TodoService,
              private http: HttpClient) { }

  ngOnInit() {
    this.getTodos();
  }

  getTodos(): void {
    this.todoService.getTodos()
      .then(todos => this.todos = todos);
  }

  createTodo(todoForm: NgForm): void {
    this.todoService.createTodo(this.newTodo)
      .then(createTodo => {
        todoForm.reset();
        this.newTodo = new Todo();
        this.todos.unshift(createTodo);
      });
  }

  deleteTodo(id: string): void {
    this.todoService.deleteTodo(id)
      .then(() => {
        this.todos = this.todos.filter(todo =>
          todo.id !== id);
      });
  }

  updateTodo(todoData: Todo): void {
    console.log(todoData);
    this.todoService.updateTodo(todoData)
      .then(updatedTodo => {
        const existingTodo = this.todos.find(todo => todo.id === updatedTodo.id);
        Object.assign(existingTodo, updatedTodo);
        this.clearEditing();
      });
  }


  editTodo(todoData: Todo): void {
    this.editing = true;
    Object.assign(this.editingTodo, todoData);
  }

  clearEditing(): void {
    this.editingTodo = new Todo();
    this.editing = false;
  }
}
