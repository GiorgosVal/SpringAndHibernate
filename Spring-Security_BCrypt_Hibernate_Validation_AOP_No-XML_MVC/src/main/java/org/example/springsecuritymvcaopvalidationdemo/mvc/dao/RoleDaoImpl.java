package org.example.springsecuritymvcaopvalidationdemo.mvc.dao;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Logger logger = Logger.getLogger(RoleDaoImpl.class.getSimpleName());

    @Override
    public Role findRoleByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("from Role where role=:roleName", Role.class);
        query.setParameter("roleName", name);
        Role role = null;
        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            logger.severe(e.toString());
        }

        return role;
    }
}
