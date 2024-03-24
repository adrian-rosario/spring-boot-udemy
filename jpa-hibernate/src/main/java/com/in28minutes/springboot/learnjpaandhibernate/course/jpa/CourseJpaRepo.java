package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;
import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepo {

  @PersistenceContext
  EntityManager myEntityManager;

  public void insert(Course course) {
    myEntityManager.merge(course);
  }

  public Course select(long id) {
    return myEntityManager.find(Course.class, id);
  }

  public void delete(long id) {
    Course courseToCheck = myEntityManager.find(Course.class, id);
    myEntityManager.remove(courseToCheck);
  }
}
