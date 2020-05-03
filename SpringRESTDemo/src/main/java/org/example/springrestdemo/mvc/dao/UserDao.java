package org.example.springrestdemo.mvc.dao;

import org.example.springrestdemo.mvc.models.User;

import java.util.List;

public interface UserDao {

    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameOrEmail(String username, String email);
    void save(User user);
}
