package com.in28minutes.springboot.learnspringboot.controllers;

public class Course {

  private long id;
  private String name;
  private String author;

  public Course() {
  }

  public Course(long id, String name, String author) {
    this.id = id;
    this.name = name;
    this.author = author;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", author='" + getAuthor() + "'" +
        "}";
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
 * ] *
 */
