package com.in28minutes.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
// correlates to the naming convention used in the application.properties
public class Configuration {
  private int min;
  private int max;

  public int getMin() {
    return this.min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return this.max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public Configuration() {
  }

  public Configuration(int min, int max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public String toString() {
    return "{" +
        " min='" + getMin() + "'" +
        ", max='" + getMax() + "'" +
        "}";
  }

}
