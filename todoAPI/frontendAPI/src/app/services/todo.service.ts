import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from '../models/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService implements TodoService {

  private readonly baseURL = 'http://localhost:9010/api/todos/';

  constructor(private http: HttpClient) { }

  getTodos(): Promise<Todo[]> {
    return this.http.get(this.baseURL)
      .toPromise()
      .then(response => response as Todo[])
      .catch(this.handleError);
  }

  createTodo(todoData: Todo): Promise<Todo> {
    return this.http.post(this.baseURL + 'create', todoData)
      .toPromise()
      .then(response => response as Todo)
      .catch(this.handleError);
  }

  updateTodo(todoData: Todo): Promise<Todo> {
    return this.http.put(this.baseURL + todoData.id, todoData)
        .toPromise()
        .then(response => response as Todo)
        .catch(this.handleError);
  }

  deleteTodo(id: string): Promise<any> {
    return this.http.delete(this.baseURL + id)
        .toPromise()
        .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An unknown error has occurred', error);
    return Promise.reject(error.message || error);
  }
}
