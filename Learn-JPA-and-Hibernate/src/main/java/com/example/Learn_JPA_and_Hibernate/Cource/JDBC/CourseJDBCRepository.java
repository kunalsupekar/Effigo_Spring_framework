package com.example.Learn_JPA_and_Hibernate.Cource.JDBC;

import java.lang.invoke.StringConcatFactory;
import java.security.KeyStore.PrivateKeyEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Learn_JPA_and_Hibernate.Cource.Course;

@Repository
public class CourseJDBCRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String iNSERT_QUERYString="""
		
		
			insert into course(id,name,author)
			 values (?,?,?);
		
			""";
	
	private static String deleteQuery="""
			delete from course where id=?
			""";
	
	private static String findByID="""
			select * from course where id=?
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(iNSERT_QUERYString,
				course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(Long id) {
		springJdbcTemplate.update(deleteQuery,id);
	}
	
	public Course findByid(Long id) {
	return springJdbcTemplate.queryForObject(findByID,
			new	BeanPropertyRowMapper<>(Course.class),id);
		
		
	}
	
}
