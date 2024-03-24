package com.in28minutes.rest.webservices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class VersioningPersionController {

  // public String name;

  // public String getName() {
  // return this.name;
  // }

  @GetMapping("/v1/person")
  public PersonV1 getPersonV1() {
    return new PersonV1("Bob Henry");
  }

  @GetMapping("/v2/person")
  public PersonV2 getPersonV2() {
    return new PersonV2(new Name("sally", "jessee"));
  }

  @GetMapping(path = "/person", params = "version=1")
  public PersonV1 getPersonByRequestParameter() {
    return new PersonV1("Bob Henry");
  }

  @GetMapping(path = "/person", params = "version=2")
  public PersonV2 getPersonByRequestParameter2() {
    return new PersonV2(new Name("sally", "jessee"));
  }

  @GetMapping(path = "/person", headers = "X-API-VERSION=1")
  public PersonV1 getPersonByRequestHeader() {
    return new PersonV1("Bob Henry");
  }

  @GetMapping(path = "/person", headers = "X-API-VERSION=2")
  public PersonV2 getPersonByRequestHeader2() {
    return new PersonV2(new Name("sally", "jessee"));
  }

  @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
  public PersonV1 getPersonByRequestAcceptHeader() {
    return new PersonV1("Bob Henry");
  }

  @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
  public PersonV2 getPersonByRequestAcceptHeaderV2() {
    return new PersonV2(new Name("sally", "jessee"));
  }
}
