package com.SpringBoot.Restful_web.HelloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "hello worl d";
	}
	
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean helloWorldbean(@PathVariable String name) {
		String string="hello word "+name;
		return new HelloWorldBean(string);
	}
	
	@GetMapping(path="/hello-world-in")
	public String helloWorldInternationalized() {
		Locale locale=LocaleContextHolder.getLocale();
		 return messageSource.getMessage("good.morning.message", null, "Default message", locale);
		
		//return "hello world internatinalization";
	}
	
}
