package com.SpringBoot.Restful_web.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SpringBoot.Restful_web.User.Jpa.PostRepository;
import com.SpringBoot.Restful_web.User.Jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {


	
	private UserRepository userRepository;
	private PostRepository postRepository;
	
	public UserJPAResource(UserRepository userRepository,PostRepository postRepository) {
		this.userRepository=userRepository;
		this.postRepository=postRepository;
	}

	// get all users
	@GetMapping(path = "/jpa/users")
	public List<User> retreiveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retreiveUserById(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id :" + id);
		}

		EntityModel< User> entityModel=EntityModel.of(user.get());
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retreiveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(locationUri).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
	userRepository.deleteById(id);
	}

	

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> reterivePostsForUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id :" + id);
		}
	return	user.get().getPosts();
		
	}
	
	
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int id,@Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id :" + id);
		}
		
		post.setUser(user.get());
		Post savedPost= postRepository.save(post);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(locationUri).build();
		
	}
}
