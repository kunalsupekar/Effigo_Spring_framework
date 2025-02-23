package com.example.flyway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	
	
	@GetMapping
	public String name() {
		return "migration completed";
	}
}
