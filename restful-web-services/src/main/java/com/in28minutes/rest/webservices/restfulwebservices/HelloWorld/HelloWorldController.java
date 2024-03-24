package com.in28minutes.rest.webservices.restfulwebservices.HelloWorld;

import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// expose rest api 
@RestController
public class HelloWorldController {

  private MessageSource messageSource;

  public HelloWorldController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  // give url to rest api
  // /hello-world
  // @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
  @GetMapping(path = "/hello-world")

  // return text back
  public String helloWorld() {
    return "Hello World 2";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() { // @RequestParam String param
    return new HelloWorldBean("hello world bean");
  }

  @GetMapping(path = "/hello-world-bean/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(
        // "hello world bean " + name
        String.format("Hello World, Path Variable %s", name));
  }

  @GetMapping(path = "/hello-world-internationalized")
  public String helloWorldInternationalized() {
    Locale locale = LocaleContextHolder.getLocale();
    return messageSource.getMessage("good.morning.message", null, "Default message", locale); // "hello world i18n";
    /*
     * 'en' 'good morning'
     * 'nl' 'goedemoren'
     * 'fr' 'bon jour'
     * 'de' 'guten morgen'
     */
  }
}
