package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// used commant T to search for Customizer, looked for the one in Security, then started the
// import path from there 
import static org.springframework.security.config.Customizer.withDefaults;

// here were are overriding the default configuration for security steps
@Configuration
public class SpringSecurityConfiguration {

  @SuppressWarnings("removal")
  @Bean
  public SecurityFilterChain mySecurityFilterChain(HttpSecurity myHttpSecurity) throws Exception {

    // authenticate requests
    // display login if no credentials
    // CSRF -> PUT, POST

    myHttpSecurity.authorizeHttpRequests(
        auth -> auth.anyRequest().authenticated());

    myHttpSecurity.httpBasic(withDefaults()); // used that search to get the right import for the withDefaults method

    myHttpSecurity.csrf().disable();

    return myHttpSecurity.build();
  }
}
