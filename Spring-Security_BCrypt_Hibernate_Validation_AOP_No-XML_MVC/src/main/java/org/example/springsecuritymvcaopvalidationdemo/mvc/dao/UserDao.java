package org.example.springsecuritymvcaopvalidationdemo.mvc.dao;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;

public interface UserDao {

    User findByUsername(String username);
    void save(User user);
}
