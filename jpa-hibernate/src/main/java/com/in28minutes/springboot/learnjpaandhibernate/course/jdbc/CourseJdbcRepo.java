package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepo {

  @Autowired
  private JdbcTemplate mySpringJdbc;

  private static String INSERT_QUERY = """
      insert into course (id, name, author)
      values(?, ?, ?);
        """;

  private static String DELETE_QUERY = """
      delete from course where id=?
        """;

  private static String SELECT_QUERY = """
      select * from course where id=?
        """;

  @SuppressWarnings("null")
  public void insert(Course course) {
    mySpringJdbc.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
  }

  @SuppressWarnings("null")
  public void delete(long id) {
    mySpringJdbc.update(DELETE_QUERY, id);
  }

  @SuppressWarnings("null")
  public Course select(long id) {
    // resultset -> bean => row mappers
    return mySpringJdbc.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
  }
}

/*
 * private static String INSERT_QUERY = """
 * insert into course (id, name, author)
 * values(1, 'learn!', 'agr');
 * """;
 */
