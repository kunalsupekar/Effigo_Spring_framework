package com.example.SpringAOP;

import java.lang.foreign.ValueLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SpringAOP.buisness.BusinessService;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	@Autowired
	private  BusinessService businessService1;
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("value return is {}",businessService1.calculateMax());
		
	}

}
