package org.example.springsecuritymvcaopvalidationdemo.mvc.dao;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Logger logger = Logger.getLogger(UserDaoImpl.class.getSimpleName());

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where username=:uname", User.class);
        query.setParameter("uname", username);
        User user = null;

        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            logger.severe(e.toString());
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where email=:e", User.class);
        query.setParameter("e", email);
        User user = null;

        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            logger.severe(e.toString());
        }
        return user;
    }

    @Override
    public List<User> findByUsernameOrEmail(String username, String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where email=:e or username=:uname", User.class);
        query.setParameter("e", email);
        query.setParameter("uname", username);
        User user = null;
        List<User> users = new ArrayList<>();
        try {
            users = query.getResultList();
        } catch (Exception e) {
            logger.severe(e.toString());
        }
        return users;
    }


    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
