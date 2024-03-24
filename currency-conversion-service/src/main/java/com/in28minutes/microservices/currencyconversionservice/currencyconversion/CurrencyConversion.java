package com.in28minutes.microservices.currencyconversionservice.currencyconversion;

import java.math.BigDecimal;

public class CurrencyConversion {
  private Long id;
  private String from;
  private String to;
  private BigDecimal quantity;
  private BigDecimal conversionMultiple;
  private BigDecimal totalCalculatedAmount;
  private String environment;

  public CurrencyConversion() {
  }

  public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
      BigDecimal totalCalculatedAmount,
      String environment) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.quantity = quantity;
    this.totalCalculatedAmount = totalCalculatedAmount;
    this.conversionMultiple = conversionMultiple;
    this.environment = environment;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTo() {
    return this.to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getFrom() {
    return this.from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public BigDecimal getQuantity() {
    return this.quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getTotalCalculatedAmount() {
    return this.totalCalculatedAmount;
  }

  public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
    this.totalCalculatedAmount = totalCalculatedAmount;
  }

  public BigDecimal getConversionMultiple() {
    return this.conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public String getEnvironment() {
    return this.environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", to='" + getTo() + "'" +
        ", from='" + getFrom() + "'" +
        ", quantity='" + getQuantity() + "'" +
        ", totalCalculatedAmount='" + getTotalCalculatedAmount() + "'" +
        ", conversionMultiple='" + getConversionMultiple() + "'" +
        ", environment='" + getEnvironment() + "'" +
        "}";
  }

}
