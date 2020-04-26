package org.example.springsecuritymvcaopvalidationdemo.mvc.services;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;
import org.example.springsecuritymvcaopvalidationdemo.mvc.models.UserRegistration;

import java.util.List;

public interface UserService {

    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameOrEmail(String username, String email);
    void save(User user);
    void save(UserRegistration userRegistration);

}
