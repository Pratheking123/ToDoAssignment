package com.java.main.Service.Impl;

import com.java.main.Model.Todo;
import com.java.main.Repo.TodoJpaRepository;
import com.java.main.Service.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements TodoRepository {
    @Autowired
    private TodoJpaRepository doRepo;

    @Override
    public List<Todo> getAllTodos() {
        return doRepo.findAll();
    }

    @Override
    public Todo saveAllTodos(Todo toDoList) {
        return doRepo.save(toDoList);
    }

    @Override
    public Todo getTodosbyId(int id) {
        return doRepo.findById(id).orElseThrow();
    }

    @Override
    public Todo updateToDo(int id, Todo toDoList) {
        toDoList.setId(id);
        return doRepo.save(toDoList);
    }

    @Override
    public void deleteToDo(int id) {
        doRepo.deleteById(id);
    }
}
