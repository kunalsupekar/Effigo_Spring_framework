package com.kunal.TodoApplication.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "todo")  // Standard table name in lowercase
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use IDENTITY for auto-increment in PostgreSQL
    private int id;

    private String description;
    private String username;
    
    @Column(name = "target_date")
    private LocalDate targetDate;

    @Column(name = "is_done")
    private boolean done;
}
