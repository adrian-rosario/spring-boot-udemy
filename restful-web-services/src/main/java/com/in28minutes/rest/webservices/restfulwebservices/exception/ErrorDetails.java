package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ErrorDetails {

  // time stamp
  // error message
  // details

  private Date timestamp;
  private String message;
  private String details;

  public ErrorDetails(Date date, String message, String details) {
    super();
    this.timestamp = date;
    this.message = message;
    this.details = details;
  }

  // public ErrorDetails(java.util.Date date, String message2, String string) {
  // // TODO Auto-generated constructor stub
  // }

  public Date getTimestamp() {
    return timestamp;
  }

  // public void setTimestamp(LocalDate timestamp) {
  // this.timestamp = timestamp;
  // }

  public String getMessage() {
    return message;
  }

  // public void setMessage(String message) {
  // this.message = message;
  // }

  public String getDetails() {
    return details;
  }

  // public void setDetails(String details) {
  // this.details = details;
  // }
}
