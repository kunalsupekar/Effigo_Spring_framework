package com.kunal.TodoApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kunal.TodoApplication.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
    List<Todo> findByUsername(String username);
}
