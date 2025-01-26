package com.In28Minutes.Spring_Boot;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {
	
	@Size(min = 4,message = "size atleast 4 ")
	 private String name;
	
	 @NotBlank(message = "Password is required.")
	 private String password;
	  public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	}