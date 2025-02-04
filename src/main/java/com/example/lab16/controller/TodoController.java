package com.example.lab16.controller;

import com.example.lab16.dto.CreateTodoItem;
import com.example.lab16.model.TodoItem;
import com.example.lab16.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(@Qualifier("MyTodoRepository")TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public List<TodoItem> getTodoList(@RequestParam(name = "status", required = false) Boolean complete) {
        if (complete != null) {
            return todoRepository.findByCompleted(complete);
        }
        return todoRepository.findAll();
    }

    @PostMapping("/")
    public TodoItem addTodoItem(@RequestBody CreateTodoItem createTodoItem) {
        return todoRepository.add(createTodoItem.getTitle());
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable(name="id") int id) {
        todoRepository.deleteById(id);
    }
}
