package com.SpringBoot.Restful_web.User.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Restful_web.User.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
