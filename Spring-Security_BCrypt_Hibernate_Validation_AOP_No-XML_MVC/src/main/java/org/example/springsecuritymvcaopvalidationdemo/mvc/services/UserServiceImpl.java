package org.example.springsecuritymvcaopvalidationdemo.mvc.services;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
