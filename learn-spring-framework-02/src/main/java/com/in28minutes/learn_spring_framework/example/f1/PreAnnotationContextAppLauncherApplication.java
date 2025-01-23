package com.in28minutes.learn_spring_framework.example.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {

	private SomeDependecny someDependecny;

	public SomeClass(SomeDependecny someDependecny) {
		//super();
		this.someDependecny = someDependecny;
		System.out.println("constructor initilization ");
	}
	
	@PostConstruct
	public void name() {
		System.out.println("hello kunal ");
	}
	
	
	@PreDestroy
	public void Cleanup() {
		System.out.println("cleanupp");
	}
}

@Component
class SomeDependecny {

}

@Configuration
@ComponentScan
public class PreAnnotationContextAppLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PreAnnotationContextAppLauncherApplication.class)) {

			// context.getBean(GamingConsole.class).goUp();

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}

	}

}
