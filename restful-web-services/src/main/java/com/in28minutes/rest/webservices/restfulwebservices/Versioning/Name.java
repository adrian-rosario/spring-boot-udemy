package com.in28minutes.rest.webservices.restfulwebservices.Versioning;

public class Name {
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "{" +
        " firstName='" + getFirstName() + "'" +
        ", lastName='" + getLastName() + "'" +
        "}";
  }
}
