package com.example.lab16.repository;

import com.example.lab16.model.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("MyTodoRepository")
public class MyTodoRepository implements TodoRepository {
    private List<TodoItem> todoItems;

    public MyTodoRepository() {
        todoItems = new ArrayList<>();
    }

    @Override
    public List<TodoItem> findAll() {
        return todoItems;
    }

    @Override
    public List<TodoItem> findByCompleted(boolean completed) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem todoItem: todoItems) {
            if (todoItem.getCompleted() == completed) {
                result.add(todoItem);
            }
        }
        return result;
    }

    @Override
    public TodoItem add(String title) {
        TodoItem todo = new TodoItem(title);
        todoItems.add(todo);
        return todo;
    }

    @Override
    public TodoItem updateStatus(int id) {
        for (TodoItem todoItem: todoItems) {
            if (todoItem.getId() == id) {
                todoItem.setCompleted(!todoItem.getCompleted());
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public List<TodoItem> uploadTodoFile(List<TodoItem> list) {
        this.todoItems = list;
        return todoItems;
    }

    @Override
    public void deleteById(int id) {
        for (TodoItem todoItem: todoItems) {
            if (todoItem.getId() == id) {
                todoItems.remove(todoItem);
                return;
            }
        }
    }

    @Override
    public List<TodoItem> searchByTitle(String title) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem todoItem: todoItems) {
            if (todoItem.getTitle().contains(title)) {
                result.add(todoItem);
            }
        }
        return result;
    }
}
