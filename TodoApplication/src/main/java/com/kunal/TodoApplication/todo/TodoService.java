package com.kunal.TodoApplication.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // Get All Todos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Get Todo by ID
    public Optional<Todo> getTodoById(int id) {
        return todoRepository.findById(id);
    }

    // Create a New Todo
    public Todo createTodo(Todo todo) {
        if (todo.getTargetDate() == null) {
            todo.setTargetDate(LocalDate.now().plusDays(7)); // Default target date
        }
        return todoRepository.save(todo);
    }

    // Update an Existing Todo
    public Optional<Todo> updateTodo(int id, Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setDescription(updatedTodo.getDescription());
            todo.setTargetDate(updatedTodo.getTargetDate());
            todo.setDone(updatedTodo.isDone());
            return todoRepository.save(todo);
        });
    }

    // Delete a Todo
    public boolean deleteTodo(int id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
}
