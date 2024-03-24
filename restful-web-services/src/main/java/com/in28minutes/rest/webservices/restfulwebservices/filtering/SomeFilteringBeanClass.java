package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties("valueOne") // or as array...{"", ""}

@JsonFilter("MyFilter")
public class SomeFilteringBeanClass {

  private String valueOne;

  // @JsonIgnore
  private String valueTwo;

  private String valueThree;

  public SomeFilteringBeanClass(String valueOne, String valueTwo, String valueThree) {
    this.valueOne = valueOne;
    this.valueTwo = valueTwo;
    this.valueThree = valueThree;
  }

  public String getValueOne() {
    return this.valueOne;
  }

  public void setValueOne(String valueOne) {
    this.valueOne = valueOne;
  }

  public String getValueTwo() {
    return this.valueTwo;
  }

  public void setValueTwo(String valueTwo) {
    this.valueTwo = valueTwo;
  }

  public String getValueThree() {
    return this.valueThree;
  }

  public void setValueThree(String valueThree) {
    this.valueThree = valueThree;
  }

  @Override
  public String toString() {
    return "{" +
        " valueOne='" + getValueOne() + "'" +
        ", valueTwo='" + getValueTwo() + "'" +
        ", valueThree='" + getValueThree() + "'" +
        "}";
  }

}
