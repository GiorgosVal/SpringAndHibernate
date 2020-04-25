package org.example.springsecuritymvcaopvalidationdemo.mvc.dao;

import org.example.springsecuritymvcaopvalidationdemo.mvc.models.Role;

public interface RoleDao {

    Role findRoleByName(String name);
}
