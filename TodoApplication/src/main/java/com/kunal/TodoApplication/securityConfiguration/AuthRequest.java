package com.kunal.TodoApplication.securityConfiguration;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;
}
