package org.example.springrestdemo.mvc.services;

import org.example.springrestdemo.mvc.dao.RoleDao;
import org.example.springrestdemo.mvc.dao.UserDao;
import org.example.springrestdemo.mvc.models.RoleType;
import org.example.springrestdemo.mvc.models.User;
import org.example.springrestdemo.mvc.models.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private Logger logger = Logger.getLogger(org.example.springrestdemo.mvc.services.UserServiceImpl.class.getSimpleName());

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findByUsernameOrEmail(String username, String email) {
        return userDao.findByUsernameOrEmail(username, email);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void save(UserRegistration userRegistration) {
        logger.info("Going to create new User for UserRegistration.");
        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.setFirstName(userRegistration.getFirstName());
        user.setLastName(userRegistration.getLastName());
        user.setEmail(userRegistration.getEmail());
        user.addRoleToUser(roleDao.findRoleByName(RoleType.CUSTOMER.toString()));
        logger.info("Going to save user: " + user);
        userDao.save(user);
    }

}
