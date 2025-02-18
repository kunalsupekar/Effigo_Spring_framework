package com.SpringBoot.Restful_web.User;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService userDaoService) {
		this.service = userDaoService;
	}

	// get all users
	@GetMapping(path = "/users")
	public List<User> retreiveAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retreiveUserById(@PathVariable int id) {

		User user = service.findById(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}

		EntityModel< User> entityModel=EntityModel.of(user);
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retreiveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(locationUri).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}

}
