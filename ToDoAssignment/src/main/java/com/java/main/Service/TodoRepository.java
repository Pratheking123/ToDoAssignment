package com.java.main.Service;

import com.java.main.Model.Todo;

import java.util.List;

public interface TodoRepository {

    public List<Todo> getAllTodos();

    public Todo saveAllTodos(Todo toDoList);

    public Todo getTodosbyId(int id);

    public Todo updateToDo(int id, Todo toDoList);

    public void deleteToDo(int id);

}
