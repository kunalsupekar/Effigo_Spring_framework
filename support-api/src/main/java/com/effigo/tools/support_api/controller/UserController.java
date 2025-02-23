package com.effigo.tools.support_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.tools.support_api.dto.UserDTO;
import com.effigo.tools.support_api.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Create a new user
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		UserDTO createdUser = userService.createUser(userDTO);
		return ResponseEntity.ok(createdUser);
	}

	// Get all users
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> usersDtos = userService.getAllUsers();
		return ResponseEntity.ok(usersDtos);
	}

	// Get user by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDTO = userService.getUserById(id);
		if (userDTO != null) {
			return ResponseEntity.ok(userDTO);
		}
		return ResponseEntity.notFound().build();
	}

	// Update a user
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		UserDTO updatedUser = userService.updateUser(id, userDTO);
		if (updatedUser != null) {
			return ResponseEntity.ok(updatedUser);
		}
		return ResponseEntity.notFound().build();
	}

	// Get user by email
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
		UserDTO userDTO = userService.getUserByEmail(email);
		if (userDTO != null) {
			return ResponseEntity.ok(userDTO);
		}
		return ResponseEntity.notFound().build();
	}

	// Login with username and password
	@PostMapping("/login")
	public ResponseEntity<UserDTO> loginUser(@RequestParam String userName, @RequestParam String password) {
		UserDTO userDTO = userService.loginUser(userName, password);
		if (userDTO != null) {
			return ResponseEntity.ok(userDTO);
		}
		return ResponseEntity.status(401).build();
	}

}
