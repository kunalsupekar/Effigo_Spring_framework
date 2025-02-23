package com.kunal.TodoApplication.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoDto {

    private int id;

    @Size(min = 4, message = "Enter at least 4 characters")
    private String description;
   
    @NotBlank(message = "username cannot be blank")
    private String username;
    
    private LocalDate targetDate;

    private Boolean done;
}
