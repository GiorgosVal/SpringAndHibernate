package org.example.springsecuritymvcaopvalidationdemo.mvc.services;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;

public interface UserService {

    User findByUsername(String username);
    void save(User user);

}
