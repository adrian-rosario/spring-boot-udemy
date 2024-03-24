package com.in28minutes.rest.webservices.restfulwebservices.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

  @Id
  @GeneratedValue
  private Integer id;
  @Size(min = 10)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore // do not provide in default response
  private User user;

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Post() {

  }

  public Post(Integer id, String description) {
    this.id = id;
    this.description = description;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", description='" + getDescription() + "'" +
        "}";
  }
}
