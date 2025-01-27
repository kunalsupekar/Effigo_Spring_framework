package com.SpringBoot.Restful_web.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	
	@GetMapping("/v1/person")
	public Person getFirstVersionOfPerson() {
		return new Person("Kunal Supekar");
	}
	
	@GetMapping("/v2/person")
	public Person2 getSecondVersionOfPerson() {
		return new Person2(new Name("Kunal"," Supekar"));
	}
	
	

	@GetMapping(path="/person",params = "version=1")
	public Person getFirstVersionOfPersonRequestParam() {
		return new Person("Kunal Supekar");
	}
	
	@GetMapping(path="/person",params = "version=2")
	public Person2 getSecondVersionOfPersonRequestParam() {
		return new Person2(new Name("Kunal"," Supekar"));
	}
	
	@GetMapping(path="/person/header",headers = "X-Api-version=1")
	public Person getFirstVersionOfPersonRequestHeaders() {
		return new Person("Kunal Supekar");
	}
	
	@GetMapping(path="/person/header",headers = "X-Api-version=2")
	public Person2 getSecondVersionOfPersonRequestheaders() {
		return new Person2(new Name("Kunal"," Supekar"));
	}
	
	@GetMapping(path="/person/accept",produces ="application/vnd.company.app-v1+json")
	public Person getFirstVersionOfPersonAcceptHeaders() {
		return new Person("Kunal Supekar");
	}
	
	@GetMapping(path="/person/accept",produces ="application/vnd.company.app-v2+json")
	public Person2 getSecondVersionOfPersonAccepttheaders() {
		return new Person2(new Name("Kunal"," Supekar"));
	}
	
}
