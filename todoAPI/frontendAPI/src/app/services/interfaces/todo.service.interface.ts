import { Todo } from './../../models/todo';

export interface TodoService {

    getTodos(): Promise<Todo[]>;

    createTodo(todoData: Todo): Promise<Todo>;

    updateTodo(id: string): Promise<Todo>;

    deleteTodo(id: string): Promise<any>;
}
