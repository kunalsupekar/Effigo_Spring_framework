package com.kunal.TodoApplication.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	List<Todo> findByDone(boolean done);
    List<Todo> findByDescriptionContaining(String keyword);
}
