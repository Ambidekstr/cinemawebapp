package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAORole;
import com.anatoliivoloshyn.cinemawebapp.entity.Role;

import java.util.List;

public class DAORole implements IDAORole {
    @Override
    public List<Role> findAllRoles() {
        return null;
    }

    @Override
    public Role findRole(String roleName) {
        return null;
    }

    @Override
    public boolean addRole(Role role) {
        return false;
    }

    @Override
    public boolean deleteRole(Role role) {
        return false;
    }
}
