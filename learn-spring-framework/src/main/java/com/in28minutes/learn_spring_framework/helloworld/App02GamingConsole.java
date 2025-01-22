package com.in28minutes.learn_spring_framework.helloworld;

//import com.in28minutes.learn_spring_framework.game.*;

//import java.nio.channels.Pipe.SourceChannel;
//import java.util.Arrays;
//
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingConsole {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(SpringBeanClassGameRunner.class);) {
			// System.out.println(context.getBean(String.class));

			// System.out.println(context.getBean("address2"));

			System.out.println(context.getBean("person2MethodCall"));

			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("person4Parameters"));
			// System.out.println(context.getBean(Address.class));

//			Arrays.stream(context.getBeanDefinitionNames()).forEach(x -> {
//				System.out.println(x);
//			});
		}

	}

}
