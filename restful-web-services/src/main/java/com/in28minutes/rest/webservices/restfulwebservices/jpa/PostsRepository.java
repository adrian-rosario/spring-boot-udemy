package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.in28minutes.rest.webservices.restfulwebservices.User.Post;

public interface PostsRepository extends JpaRepository<Post, Integer> {

}
