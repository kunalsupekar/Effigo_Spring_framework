package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age,Address address) {
};

record Address(String firstLine,String city) {};

@Configuration
public class SpringBeanClassGameRunner {

	@Bean
	public String name1() {
		return "kunal supekar";
	}

	@Bean
	public Person person1() {
		var person = new Person("Sairaj", 16,new Address("NewYork", "London") );
	
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name1(),age(),address());
	
		return person;
	}
	
	
	@Bean
	@Primary
	public Person person3Parameters(String name1,int age,Address address) {
		var person = new Person(name1,age,address);
	
		return person;
	}
	
	@Bean
	public Person person4Parameters(String name1,int age,@Qualifier("address3Qualifier") Address address) {
		var person = new Person(name1,age,address);
	
		return person;
	}
	

	@Bean
	public int age() {
		// TODO Auto-generated method stub
		return 18;
	}

	@Bean(name = "address2")
	public Address address() {
		var address = new Address("Nighoj", "Pune");
	
		return address;
	}
	

	@Bean(name = "address3")
	@Primary
	public Address address3() {
		var address = new Address("Sandeigo", "miami");
	
		return address;
	}
	
	
	@Bean(name = "address4")
	@Qualifier("address3Qualifier")
	public Address address4() {
		var address = new Address("Russia", "japan");
	
		return address;
	}
}
