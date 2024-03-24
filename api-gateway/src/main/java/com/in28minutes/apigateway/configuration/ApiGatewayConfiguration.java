package com.in28minutes.apigateway.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

    return builder.routes()
        .route(p -> p.path("/get")
            .filters(f -> f.addRequestHeader("MyHeader", "MyValue")
                .addRequestParameter("MyParameter", "MyValue"))
            .uri("http://httpbin.org:80"))
        .route(
            // request method
            // host
            // headers
            // match
            // query parameter

            p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service/"))
        .route(
            p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service/"))
        .route(
            p -> p.path("/**-feign**").uri("lb://currency-conversion-service/"))
        .route(
            p -> p.path("/agr/**").filters(f -> f.rewritePath("/agr", "/currency-conversion"))
                .uri("lb://currency-conversion-service/"))
        .route(
            p -> p.path("/agr-feign/**").filters(f -> f.rewritePath("/agr-feign", "/currency-conversion"))
                .uri("lb://currency-conversion-service/"))
        .build();
  }
}

// http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

/*
 * Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
 * .filters(f ->
 * // add request header on top of /get request
 * f.addRequestHeader("MyHeader", "MyUri")
 * // add request parameter to get request: /get?Param=MyParamValue"
 * .addRequestParameter("Param", "MyParamValue"))
 * .uri("http://httpbin.org:80");
 * // http://httpbin.org:80
 * return builder.routes()
 * .route(routeFunction)
 * .build();
 */