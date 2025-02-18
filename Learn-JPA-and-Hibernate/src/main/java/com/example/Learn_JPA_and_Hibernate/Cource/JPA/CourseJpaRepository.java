package com.example.Learn_JPA_and_Hibernate.Cource.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Learn_JPA_and_Hibernate.Cource.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findByid(Long id) {
	return	entityManager.find(Course.class, id);
	}
	
	public void delete(Long id) {
		Course course=entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
}
