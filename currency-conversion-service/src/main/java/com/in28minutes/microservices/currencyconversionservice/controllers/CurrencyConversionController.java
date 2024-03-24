package com.in28minutes.microservices.currencyconversionservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.in28minutes.microservices.currencyconversionservice.currencyconversion.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.proxies.CurrencyExchangeProxy;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// added in zipkin steps, this would normally be in it's own class/shared
@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
  @Bean
  RestTemplate restTemplate(RestTemplateBuilder templateBuilder) {
    return templateBuilder.build();
  }
}

@RestController
public class CurrencyConversionController {

  @Autowired
  private CurrencyExchangeProxy myProxy;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion getConvertedValues(@PathVariable String to, @PathVariable String from,
      @PathVariable BigDecimal quantity) {

    HashMap<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    // updated to us the rest template above or else we dont get the full trace in
    // zipkin/micrometer
    // then you can trace the request across microservices
    ResponseEntity<CurrencyConversion> responseEntitiy = restTemplate.getForEntity
    // new RestTemplate().getForEntity(
    ("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

    CurrencyConversion currencyConversion = responseEntitiy.getBody();

    return new CurrencyConversion(
        currencyConversion.getId(),
        from, to, quantity,
        currencyConversion.getConversionMultiple(),
        quantity.multiply(currencyConversion.getConversionMultiple()),
        currencyConversion.getEnvironment());

    /*
     * return new CurrencyConversion(
     * 1001L,
     * from,
     * to,
     * quantity,
     * BigDecimal.ONE,
     * BigDecimal.ONE,
     * "qa1");
     */
  }

  @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion getConvertedValuesFeign(@PathVariable String to, @PathVariable String from,
      @PathVariable BigDecimal quantity) {

    CurrencyConversion currencyConversion = myProxy.retrieveExchangeValue(from, to); // responseEntitiy.getBody();

    return new CurrencyConversion(
        currencyConversion.getId(),
        from, to, quantity,
        currencyConversion.getConversionMultiple(),
        quantity.multiply(currencyConversion.getConversionMultiple()),
        currencyConversion.getEnvironment() + "-feign");

  }
}
