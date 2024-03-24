package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.User.Post;
import com.in28minutes.rest.webservices.restfulwebservices.User.User;
import com.in28minutes.rest.webservices.restfulwebservices.User.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.User.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserJpaResource {
  private UserDaoService daoService; // no longer needed after switching to Jpa repo...

  private UserRepository repository;
  private PostsRepository postsRepository;

  public UserJpaResource(UserDaoService daoService, UserRepository repository, PostsRepository postsRepository) {
    this.daoService = daoService;
    this.repository = repository;
    this.postsRepository = postsRepository;
  }

  @GetMapping("/jpa/users")
  public List<User> getAllUsers() {
    // return daoService.findAll();
    return repository.findAll();
  }

  /*
   * hateaos
   * EntityModel
   * WebMvcLinkBuilder
   */

  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> getUser(@PathVariable int id) {
    Optional<User> user = repository.findById(id); // daoService.findOne(id);

    if (/* user == null */ user.isEmpty()) {
      throw new UserNotFoundException("User ID Not found: " + id);
    }

    @SuppressWarnings("null")
    EntityModel<User> entityModel = EntityModel.of(/* user */ user.get());

    @SuppressWarnings("null")
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

  @PostMapping("/jpa/users")
  public ResponseEntity<Object> addUser(@Valid @RequestBody User user) { // @RequestBody String entity
    @SuppressWarnings("null")
    User savedUser = repository.save(user); // daoService.AddUser(user);
    // so we can utilize the created user id in the response after creating a new
    // user
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build(); // in the Postman response, shows up under Headers
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {
    // daoService.removeOne(id);
    repository.deleteById(id);
  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> getPosts(@PathVariable int id) {

    // private List myList ;

    Optional<User> user = repository.findById(id); // daoService.findOne(id);

    if (user.isEmpty()) {
      throw new UserNotFoundException("User ID Not found: " + id);
    }

    return user.get().getPosts();

    // @SuppressWarnings("null")
    // EntityModel<User> entityModel = EntityModel.of(/* user */ user.get());

    // return myList;
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Object> createPost(
      @PathVariable int id,
      @Valid @RequestBody Post post) {

    // private List myList ;

    Optional<User> user = repository.findById(id); // daoService.findOne(id);

    if (user.isEmpty()) {
      throw new UserNotFoundException("User ID Not found: " + id);
    }

    post.setUser(user.get());

    Post savedPost = postsRepository.save(post);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedPost.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  // @GetMapping("/jpa/users/{id}/posts/{id}")
  // public Post getPost(@PathVariable int id, @PathVariable int postId) {
  // Optional<User> user = repository.findById(id); // daoService.findOne(id);

  // if (user.isEmpty()) {
  // throw new UserNotFoundException("User ID Not found: " + id);
  // }

  // // post.setUser(user.get());

  // // Post savedPost = postsRepository.get(post);
  // }
}
