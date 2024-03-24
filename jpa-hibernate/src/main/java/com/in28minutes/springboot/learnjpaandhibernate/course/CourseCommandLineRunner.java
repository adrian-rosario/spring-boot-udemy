package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepo;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepo;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpa;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

  // @Autowired
  // private CourseJdbcRepo myCourseRepo;

  // @Autowired
  // private CourseJpaRepo myCourseRepo;

  @Autowired
  private CourseSpringDataJpa myCourseRepo;

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub

    // myCourseRepo.insert(new Course(1, "learn Java", "agrz"));
    // myCourseRepo.insert(new Course(2, "learn lambda", "agrz"));
    // myCourseRepo.insert(new Course(3, "cad / cam", "agrz"));

    myCourseRepo.save(new Course(1, "learn Java!!", "agrz"));
    myCourseRepo.save(new Course(2, "learn lambda!!", "agrz"));
    myCourseRepo.save(new Course(3, "cad / cam!!", "agrz"));
    myCourseRepo.save(new Course(4, "guitar", "gamal"));

    // myCourseRepo.delete(1);
    // System.out.println(myCourseRepo.select(2));

    myCourseRepo.deleteById(1l);
    System.out.println(myCourseRepo.findById(2l));
    System.out.println(myCourseRepo.findAll());
    System.out.println(myCourseRepo.count());
    System.out.println(myCourseRepo.findByAuthor("gamal"));
    System.out.println(myCourseRepo.findByName("cad / cam!!"));
    // throw new UnsupportedOperationException("Unimplemented method 'run'");
  }

}
