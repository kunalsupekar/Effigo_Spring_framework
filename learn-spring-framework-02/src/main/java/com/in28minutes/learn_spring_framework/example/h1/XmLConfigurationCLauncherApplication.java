package com.in28minutes.learn_spring_framework.example.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learn_spring_framework.game.GameRunner;




public class XmLConfigurationCLauncherApplication {

	public static void main(String[] args) {

		try (var context = new 
				ClassPathXmlApplicationContext("ContextConfiguration.xml"))
				{

			
			System.out.println("hello XML configuration ");
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			context.getBean(GameRunner.class).runGame();
			
		}

	}

}
