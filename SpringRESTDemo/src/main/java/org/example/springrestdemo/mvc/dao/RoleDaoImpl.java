package org.example.springrestdemo.mvc.dao;

import org.example.springrestdemo.mvc.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository(value = "roleDao")
public class RoleDaoImpl implements org.example.springrestdemo.mvc.dao.RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Logger logger = Logger.getLogger(org.example.springrestdemo.mvc.dao.RoleDaoImpl.class.getSimpleName());

    @Override
    public Role findRoleByName(String name) {
        logger.info("Going to search for role: " + name);
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role where role=:roleName", Role.class);
        query.setParameter("roleName", name);
        Role role = null;
        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            logger.severe(e.toString());
        }
        logger.info("Role to be returned: " + role);
        return role;
    }
}
