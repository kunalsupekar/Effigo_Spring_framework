package com.kunal.TodoApplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunal.TodoApplication.dto.TodoDto;
import com.kunal.TodoApplication.exception.TodoNotFoundException;
import com.kunal.TodoApplication.exception.UsernameNotFoundException;
import com.kunal.TodoApplication.model.Todo;
import com.kunal.TodoApplication.repository.TodoRepository;
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(this::todoToDto).toList();
    }

    public TodoDto getTodoById(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with ID " + id + " not found"));
        return todoToDto(todo);
    }


    //todos by username
	public List<TodoDto> getAllTodosByUsername(String username) {
		 List<Todo> todos = todoRepository.findByUsername(username);
		    if (todos.isEmpty()) {
		        throw new UsernameNotFoundException("Username: " + username + ", not found");
		    }
  
		 return todos.stream().map(this::todoToDto).toList();
	}
    
    
    public TodoDto createTodo(TodoDto todoDto) {
        if (todoDto.getId() != 0) {
            throw new IllegalArgumentException("Id must not be provided for a new Todo");
        }
        Todo todo = dtoToTodo(todoDto);
        if (todo.getTargetDate() == null) {
            todo.setTargetDate(LocalDate.now().plusDays(7));
        }
        Todo savedTodo = todoRepository.save(todo);
        return todoToDto(savedTodo);
    }

    public Optional<TodoDto> updateTodo(int id, TodoDto updatedTodoDto) {
        return todoRepository.findById(id).map(existingTodo -> {
            existingTodo.setDescription(updatedTodoDto.getDescription());
            existingTodo.setTargetDate(updatedTodoDto.getTargetDate());
            existingTodo.setDone(updatedTodoDto.getDone());
            Todo updatedTodo = todoRepository.save(existingTodo);
            return todoToDto(updatedTodo);
        });
    }

    public void deleteTodo(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with ID " + id + " not found"));
        todoRepository.delete(todo);
    }


    // Convert TodoDto to Todo entity
    private Todo dtoToTodo(TodoDto todoDto) {	
        Todo todo= modelMapper.map(todoDto, Todo.class);
       
        return todo;
    }

    // Convert Todo entity to TodoDto
    private TodoDto todoToDto(Todo todo) {
        return modelMapper.map(todo, TodoDto.class);
    }

}
