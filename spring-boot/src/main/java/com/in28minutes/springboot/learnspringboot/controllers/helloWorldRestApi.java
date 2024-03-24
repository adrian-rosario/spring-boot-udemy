package com.in28minutes.springboot.learnspringboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldRestApi {

  @GetMapping("/courses")
  public List<Course> getAllCourses() {
    return Arrays.asList(
        new Course(1, "full stack", "agr"),
        new Course(2, "oracle", "agr"),
        new Course(3, "cad / cam", "agr"),
        new Course(4, "cpaac", "agr")
    // new Course(1,"learn full stack", "agr")
    );
  }

}

/*
 * http://localhost:8080/courses
 * 
 * [
 * {
 * "id":1,
 * "name":"full stack",
 * "author":"agr"
 * }
 * ]
 */