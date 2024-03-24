package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpa extends JpaRepository<Course, Long> {

  // insert
  // delete
  // select
  List<Course> findByAuthor(String author);

  List<Course> findByName(String name);

}
