package com.java.main.Controller;

import com.java.main.Model.Todo;
import com.java.main.Service.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoRepository toDoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        try {
            List<Todo> toDoLists = toDoService.getAllTodos();
            if (toDoLists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(toDoLists, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Todo> saveAllTodos(@RequestBody Todo toDoList) {
        try {
            Todo toDoList1 = toDoService.saveAllTodos(toDoList);
            if (toDoList1 == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(toDoList1, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodosbyId(@PathVariable("id") int id) {
        try {
            if (id <= 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Todo toDoList = toDoService.getTodosbyId(id);
            if (toDoList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(toDoList, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateToDo(@PathVariable("id") int id, @RequestBody Todo toDoList) {
        try {
            if (id <= 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Todo updatedToDoList = toDoService.updateToDo(id, toDoList);
            if (updatedToDoList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedToDoList, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable("id") int id) {
        try {
            if (id <= 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            toDoService.deleteToDo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
