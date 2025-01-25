package com.example.MyFirstWebApplication.todo;

import java.lang.invoke.StringConcatFactory;
import java.security.KeyStore.PrivateKeyEntry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 0;
	static {
		todos.add(new Todo(todoCount++, "in28minutes", "learn aws", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(todoCount++, "Devops", "kunal", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(todoCount++, "Monitoring", "Kubernetes aws", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targeDate, boolean b) {
		// TODO Auto-generated method stub
		todos.add(new Todo(todoCount++, username, description, targeDate, b));
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateToDo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
