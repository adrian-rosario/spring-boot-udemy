package com.in28minutes.springboot.learnspringboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

  /*
   * currency-service.url=
   * currency-service.username=
   * currency-service.key=
   */

  private String url;
  private String username;
  private String key;

  public CurrencyServiceConfiguration() {
  }

  public CurrencyServiceConfiguration(String url, String username, String key) {
    this.url = url;
    this.username = username;
    this.key = key;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
