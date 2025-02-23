package com.kunal.TodoApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.TodoApplication.dto.TodoDto;
import com.kunal.TodoApplication.exception.UsernameNotFoundException;
import com.kunal.TodoApplication.service.TodoService;

@RestController
@RequestMapping("/todos")  // This will prefix all paths with /todos, making your structure more consistent
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/hello")
    public String hello() {
    	return "hello from restApi using token  	" ;
    }
    
    @GetMapping("/basicauth")
    public String basicauth() {
    	return "basic authentication successful " ;
    }
    
    // Get All Todos (Admin only)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // Get Todos by Username (Admin or user viewing own todos)
    @PreAuthorize("hasAuthority('ROLE_USER') and #username == authentication.name or hasAuthority('ROLE_ADMIN')")
    @GetMapping("/users/{username}")
    public ResponseEntity<List<TodoDto>> retrieveAllTodosByUsername(@PathVariable String username) {
        List<TodoDto> todos = todoService.getAllTodosByUsername(username);
        return ResponseEntity.ok(todos);
    }

    // Get Todo by ID (Admin only)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable int id) {
        TodoDto todoDto = todoService.getTodoById(id);
        return ResponseEntity.ok(todoDto);
    }

    // Create a New Todo (Admin and User allowed)
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@Validated @RequestBody TodoDto todoDto) {
        TodoDto createdTodo = todoService.createTodo(todoDto);
        return ResponseEntity.status(201).body(createdTodo);
    }

    // Update an Existing Todo (Admin or User updating own Todo)
    @PreAuthorize("hasAuthority('ROLE_USER') and #updatedTodoDto.username == authentication.name or hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable int id, @Validated @RequestBody TodoDto updatedTodoDto) {
        return todoService.updateTodo(id, updatedTodoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Todo (Admin only)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
