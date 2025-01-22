package com.in28minutes.learn_spring_framework.example.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {

	ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("Initilization ");
		this.classA = classA;

	}
	
	public  void doSomething() {
		System.out.println("do something");
	}
}

@Configuration
@ComponentScan
public class SimpleAppLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(SimpleAppLauncherApplication.class)) {

			//context.getBean(GamingConsole.class).goUp();

			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			context.getBean(ClassB.class).doSomething();
		}

	}

}
