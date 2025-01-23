package com.in28minutes.learn_spring_framework.example.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


//@Component
@Named
class BuisnessService{
	
	private DataService dataService;

	
	
	//@Autowired
	@Inject
	public void setDataservice(DataService dataService) {
		System.out.println("Setter Injection !! ");
		this.dataService = dataService;
		
	}
	
	public DataService getDataservice() {
		//
		return dataService;
	}
	
	
	
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiCLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(CdiCLauncherApplication.class)) {

			

			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			
			System.out.println(context.getBean(BuisnessService.class).getDataservice());
			
		}

	}

}
