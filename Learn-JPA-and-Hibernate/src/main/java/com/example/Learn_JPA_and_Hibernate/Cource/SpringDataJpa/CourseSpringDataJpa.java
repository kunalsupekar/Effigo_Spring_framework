package com.example.Learn_JPA_and_Hibernate.Cource.SpringDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Learn_JPA_and_Hibernate.Cource.Course;

public interface CourseSpringDataJpa extends JpaRepository<Course,Long>{
	
	List<Course> findByAuthor(String author);
	
}
