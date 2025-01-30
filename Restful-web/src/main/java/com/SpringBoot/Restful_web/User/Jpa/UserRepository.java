package com.SpringBoot.Restful_web.User.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Restful_web.User.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
