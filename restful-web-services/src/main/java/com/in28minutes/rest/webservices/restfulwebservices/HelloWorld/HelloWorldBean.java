package com.in28minutes.rest.webservices.restfulwebservices.HelloWorld;

public class HelloWorldBean {

  private String message;

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HelloWorldBean(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "{" +
        " message='" + getMessage() + "'" +
        "}";
  }

}
