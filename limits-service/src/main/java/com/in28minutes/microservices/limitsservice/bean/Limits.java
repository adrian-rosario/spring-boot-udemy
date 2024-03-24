package com.in28minutes.microservices.limitsservice.bean;

public class Limits {
  private int lowerLimit;
  private int upperLimit;

  public Limits() {
  }

  public Limits(int lowerLimit, int upperLimit) {
    this.lowerLimit = lowerLimit;
    this.upperLimit = upperLimit;
  }

  public int getLowerLimit() {
    return this.lowerLimit;
  }

  public void setLowerLimit(int lowerLimit) {
    this.lowerLimit = lowerLimit;
  }

  public int getUpperLimit() {
    return this.upperLimit;
  }

  public void setUpperLimit(int upperLimit) {
    this.upperLimit = upperLimit;
  }

  @Override
  public String toString() {
    return "{" +
        " lowerLimit='" + getLowerLimit() + "'" +
        ", upperLimit='" + getUpperLimit() + "'" +
        "}";
  }
}
