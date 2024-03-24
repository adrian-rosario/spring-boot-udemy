package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component // so Spring manages this...
public class UserDaoService {

  // JPA/Hibernate talk to DB
  // Static List for now
  private static List<User> users = new ArrayList<>();
  private static int count = 0;

  static {
    users.add(new User(++count, "Thomas Tin", LocalDate.now().minusYears(63)));
    users.add(new User(++count, "Fred Art", LocalDate.now().minusYears(30)));
    users.add(new User(++count, "Michael Swan", LocalDate.now().minusYears(16)));
  }

  public List<User> findAll() {
    return users;
  }

  // public User save(User user){}
  public User findOne(int id) {
    // functional programming, taking list, converting to stream, filtering based on
    // predicate (match id that's passed in)
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    return users.stream().filter(predicate).findFirst().orElse(null);
  }

  public User AddUser(User user) {
    user.setId(++count);
    users.add(user);
    return user;
  }

  public void removeOne(int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    users.removeIf(predicate);
    users.stream().filter(predicate).findFirst().orElse(null);
  }
}

//
// * understand predicate better
//