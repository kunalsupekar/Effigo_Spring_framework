package com.in28minutes.learn_spring_framework.Exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {

	
	public static void main(String[] args) {
		
		
		System.out.println("Hello this is main classs");
	 var context=new AnnotationConfigApplicationContext(Main.class);
	 
	 Arrays.stream(context.getBeanDefinitionNames())
	 .forEach(a->System.out.println(a));
	 
	 var a=context.getBean(BuisnessCalculateService.class).findMax();
	 System.out.println(a);
	}
}
