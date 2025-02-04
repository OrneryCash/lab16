package com.example.lab16.repository;

import com.example.lab16.model.TodoItem;
import java.util.List;

public interface TodoRepository {
    List<TodoItem> findAll();
    List<TodoItem> findByCompleted(boolean completed);
    TodoItem add(String title);
    TodoItem updateStatus(int id);
    List<TodoItem> uploadTodoFile(List<TodoItem> todoItems);
    void deleteById(int id);
    List<TodoItem> searchByTitle(String title);
}
