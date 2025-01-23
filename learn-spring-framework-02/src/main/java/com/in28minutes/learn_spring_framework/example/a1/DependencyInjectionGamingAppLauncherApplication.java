package com.in28minutes.learn_spring_framework.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBuisnessClass {
	
	Dependency1 dependency1;
	
	Dependency2 dependency2;

	@Autowired
	public YourBuisnessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor injection ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Set dependecy 1 :setter injection");
		this.dependency1 = dependency1;
	}

	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Set dependecy 2 ");
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "using " + dependency1 + "  " + dependency2;
	}
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DependencyInjectionGamingAppLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(
				DependencyInjectionGamingAppLauncherApplication.class)) {

			// context.getBean(GamingConsole.class).goUp();

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			
	System.out.println(context.getBean(YourBuisnessClass.class));
		
		
		
		}

	}

}
