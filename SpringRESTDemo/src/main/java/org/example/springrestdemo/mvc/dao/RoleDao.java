package org.example.springrestdemo.mvc.dao;

import org.example.springrestdemo.mvc.models.Role;

public interface RoleDao {

    Role findRoleByName(String name);
}
