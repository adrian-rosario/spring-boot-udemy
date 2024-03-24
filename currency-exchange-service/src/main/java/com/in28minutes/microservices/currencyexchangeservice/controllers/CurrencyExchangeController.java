package com.in28minutes.microservices.currencyexchangeservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CurrencyExchangeController {

  // private Environment serverEnvironment;
  private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

  @Autowired
  private CurrencyExchangeRepository myExchangeRepository; //

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private CurrencyExchangeRepository repository;

  @GetMapping("currency-exchange/from/{from}/to/{to}")
  // currency-exchange/from/USD/to/INR
  public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

    logger.info("retrieveExchangeValue called with {} and {}", from, to);

    // String serverPort = serverEnvironment.getProperty("local.server.port"); //
    // throws error and I'm tired
    // int thePort = request.getServerPort();
    String theEnv = "" + request.getRequestURL();

    CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

    if (currencyExchange == null) {
      throw new RuntimeException("Unable to compute for values: " + from + " and: " + to);
    }

    currencyExchange.setEnvironment(theEnv);
    // CurrencyExchange curEx = new CurrencyExchange();
    // curEx.setId(1000L);
    // curEx.setTo(to);
    // curEx.setFrom(from);
    // curEx.setEnvironment(theEnv);

    return currencyExchange; // curEx;
  }

  /*
   * We will make use of these in the next lecture!
   * 
   * URL
   * http://localhost:8000/currency-exchange/from/USD/to/INR
   * 
   * Response Structure
   * {
   * "id":10001,
   * "from":"USD",
   * "to":"INR",
   * "conversionMultiple":65.00,
   * "environment":"8000 instance-id"
   * }
   * 
   */

}
