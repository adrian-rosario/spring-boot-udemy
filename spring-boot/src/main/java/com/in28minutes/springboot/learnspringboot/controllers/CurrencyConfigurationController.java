package com.in28minutes.springboot.learnspringboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.learnspringboot.configuration.CurrencyServiceConfiguration;

@RestController
public class CurrencyConfigurationController {

  @Autowired
  private CurrencyServiceConfiguration currencyServiceConfiguration;

  private Logger logger = LoggerFactory.getLogger(CurrencyConfigurationController.class);

  @GetMapping("/currency-configuration")
  public CurrencyServiceConfiguration getCurrencyConfiguration() {
    // Log information = new Log(currencyServiceConfiguration.getUsername());
    logger.info("*****LOGGING***** " + currencyServiceConfiguration.getUsername());
    return currencyServiceConfiguration;
  }
}
