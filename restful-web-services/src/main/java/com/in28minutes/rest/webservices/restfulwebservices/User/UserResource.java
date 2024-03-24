package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserResource {
  private UserDaoService daoService;

  public UserResource(UserDaoService daoService) {
    this.daoService = daoService;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return daoService.findAll();
  }

  /*
   * hateaos
   * EntityModel
   * WebMvcLinkBuilder
   */

  @GetMapping("/users/{id}")
  public EntityModel<User> getUser(@PathVariable int id) {
    User user = daoService.findOne(id);

    if (user == null) {
      throw new UserNotFoundException("User ID Not found: " + id);
    }

    EntityModel<User> entityModel = EntityModel.of(user);

    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

    entityModel.add(link.withRel("all-users"));

    return entityModel;
    /*
     * Before hateoas:
     * public User getUser(@PathVariable int id) {
     * User user = daoService.findOne(id);
     * 
     * if (user == null) {
     * throw new UserNotFoundException("User ID Not found: " + id);
     * }
     * 
     * return user;
     */
  }

  @PostMapping("/users")
  public ResponseEntity<Object> addUser(@Valid @RequestBody User user) { // @RequestBody String entity
    User savedUser = daoService.AddUser(user);
    // so we can utilize the created user id in the response after creating a new
    // user
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build(); // in the Postman response, shows up under Headers
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    daoService.removeOne(id);
  }
}
