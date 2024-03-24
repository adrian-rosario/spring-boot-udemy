package com.in28minutes.microservices.currencyconversionservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.currencyconversionservice.currencyconversion.CurrencyConversion;

// w/o eureka
// @FeignClient(name = "currency-exchange-service", url = "localhost:8000")

// with eureka
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

  @GetMapping("currency-exchange/from/{from}/to/{to}")
  public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
