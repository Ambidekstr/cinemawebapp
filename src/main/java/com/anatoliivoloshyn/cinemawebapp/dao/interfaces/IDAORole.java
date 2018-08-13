package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Role;

import java.util.List;

public interface IDAORole {
    List<Role> findAllRoles();
    Role findById(long id);
    boolean addRole(Role role);
    boolean deleteRole(Role role);

}
