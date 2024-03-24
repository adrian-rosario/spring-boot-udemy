package com.in28minutes.microservices.currencyexchangeservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CircuitBreakerController {

  private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

  @GetMapping("/sampleApi")
  @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

  // @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") // if there
  // is an exception, it will retry 3x, w/o
  // chaing w/ properties file
  public String sampleApi() {

    logger.info("sample api call received");

    // return "Samle api response";
    ResponseEntity<String> forEntity = new RestTemplate().getForEntity(
        "http://localhost:8080/dummy-url", String.class);
    return forEntity.getBody();
  }

  public String hardcodedResponse(Exception ex) {
    logger.info("FALLBACK RESPONSE");
    return "Fallback Response: " + ex.getLocalizedMessage();
  }
}
