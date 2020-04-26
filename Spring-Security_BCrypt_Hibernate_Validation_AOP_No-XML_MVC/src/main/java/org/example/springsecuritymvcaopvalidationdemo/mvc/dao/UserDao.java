package org.example.springsecuritymvcaopvalidationdemo.mvc.dao;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;

import java.util.List;

public interface UserDao {

    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameOrEmail(String username, String email);
    void save(User user);
}
