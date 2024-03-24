package com.in28minutes.rest.webservices.restfulwebservices.Versioning;

public class PersonV1 {
  private String name;

  public String getName() {
    return this.name;
  }

  public PersonV1(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{" +
        " name='" + getName() + "'" +
        "}";
  }

}
