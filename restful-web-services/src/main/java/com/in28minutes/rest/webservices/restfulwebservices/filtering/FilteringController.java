package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FilteringController {

  // two apis, one does not provide all fields, ie. dob or other info we don't
  // want to expose to all clients

  // String myToad = "some toad in a string";
  SomeFilteringBeanClass xyz = new SomeFilteringBeanClass("value one !", "value two", "value threE");

  @GetMapping("/filtering")
  public MappingJacksonValue /* SomeFilteringBeanClass */ someFilteringBeanClass() {

    // return new SomeFilteringBeanClass("value one", "value two", "value three");

    SomeFilteringBeanClass someBean = xyz; // new SomeFilteringBeanClass("value one", "value two", "value three");
    @SuppressWarnings("null")
    MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);

    SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("valueThree");

    FilterProvider filters = new SimpleFilterProvider().addFilter("MyFilter", myFilter);
    jacksonValue.setFilters(filters);

    // System.out.println(myToad);

    return jacksonValue;
  }

  @GetMapping("/filtering-list")
  public MappingJacksonValue secondFilteringBeanClass() {
    List<SomeFilteringBeanClass> myList = Arrays.asList(
        // new SomeFilteringBeanClass("value one", "value two", "value three"),
        xyz,
        new SomeFilteringBeanClass("value four", "value five", "value six"));
    @SuppressWarnings("null")
    MappingJacksonValue jacksonValue = new MappingJacksonValue(myList);

    SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("valueOne", "valueTwo");

    FilterProvider filters = new SimpleFilterProvider().addFilter("MyFilter", myFilter);
    jacksonValue.setFilters(filters);

    return jacksonValue;

  }
  // public List<SomeFilteringBeanClass> filteringList() {
  // return Arrays.asList(
  // new SomeFilteringBeanClass("value one", "value two", "value three"),
  // new SomeFilteringBeanClass("value four", "value five", "value six"));
  // }

}
