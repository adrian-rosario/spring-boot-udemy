package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
  // since "user" is also a used keyword there will be an error w/ jpa, so we have
  // to give it an alias to use "user"

  @Id
  @GeneratedValue
  private Integer id;

  @Size(min = 2, message = "Name should be at least two characters") // validation

  @JsonProperty("user_name") // Jackson, will now appear in JSON w/ that string instead of "name"
  private String name;

  @Past(message = "Date cannot be in the future") // validation

  @JsonProperty("birth_date") // Jackson, will now appear in JSON w/ that string instead of "dob"
  private LocalDate dob;

  /* public */ protected User() {
  } // if you see no default constructor error
  // saw empty constructor added in jpa hibernate appendix segment

  public User(Integer id, String name, LocalDate dob) {
    super();
    this.id = id;
    this.name = name;
    this.dob = dob;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDob() {
    return this.dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  @OneToMany(mappedBy = "user")
  @JsonIgnore // so it's not provided by default in the json response
  private List<Post> posts;

  public List<Post> getPosts() {
    return this.posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", dob='" + getDob() + "'" +
        "}";
  }
}
