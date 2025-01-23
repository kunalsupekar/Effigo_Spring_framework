package com.example.Learn_JPA_and_Hibernate.Cource;

import java.nio.channels.Pipe.SourceChannel;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Learn_JPA_and_Hibernate.Cource.JDBC.CourseJDBCRepository;
import com.example.Learn_JPA_and_Hibernate.Cource.JPA.CourseJpaRepository;
import com.example.Learn_JPA_and_Hibernate.Cource.SpringDataJpa.CourseSpringDataJpa;

@Component
public class CourseCommandLinerunner implements CommandLineRunner {

//	@Autowired
//	private CourseJDBCRepository	repository;
//	
//	@Autowired
//	private CourseJpaRepository repository;
//	
	
	
	@Autowired
	private CourseSpringDataJpa repository;
	
	
	@Override
	public void run(String... args) throws Exception {
//		
//	repository.insert(new Course(1,"Im monk","Jay Shetty"));
//	repository.insert(new Course(2,"think ","Jay Shetty"));
//	repository.insert(new Course(3,"AWS monk","Jay Shetty"));
//	repository.insert(new Course(4,"think monk","Jay Sharma"));
		
		
		repository.save(new Course(1,"Im monk","Jay Shetty"));
		repository.save(new Course(2,"think ","Jay Shetty"));
		repository.save(new Course(3,"AWS monk","Jay Shetty"));
		repository.save(new Course(4,"think monk","Jay Sharma"));
		
	repository.deleteById(4L);
	System.out.println(repository.findById(2L));
	System.out.println(repository.findByAuthor("Jay Shett"));
	repository.findAll().stream().forEach(System.out::println);
	System.out.println(repository.count());
	
	
	
	
	}

}
