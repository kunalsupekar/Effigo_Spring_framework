package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class App03GamingSpringBeans {


	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {

			//context.getBean(GamingConsole.class).goUp();

			context.getBean(GameRunner.class).runGame();

		}

	}

}
