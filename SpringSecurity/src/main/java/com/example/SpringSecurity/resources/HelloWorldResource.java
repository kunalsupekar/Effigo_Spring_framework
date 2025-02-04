package com.example.SpringSecurity.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	private static final List<Todo> TODOS_LIST = 
			List.of(new Todo("kunal", "Learn AWS"),
					new Todo("in28minutes", "Get AWS Certified"));

	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    System.out.println("Authenticated User: " + authentication.getName());
	    return TODOS_LIST;
	}
	
	
	@GetMapping("/users/{username}/todos")
	@PreAuthorize("hasAuthority('ROLE_USER') and #username == authentication.name")
	public Todo retrieveTodosForSpecificUser(@PathVariable("username") String username) {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    System.out.println("Authenticated user: " + authentication.getName());
		    System.out.println("Requested username: " + username);
		
		return TODOS_LIST.get(0);
	}
	
	@PostMapping("/users/{username}/todos")
	public void createTodosForSpecificUser(@PathVariable("username") String username,
			@RequestBody Todo todo) {
		logger.info("creating todo {} for {} ",todo,username);
		
	}
	
	
}


record Todo(String username,String description) {

}