package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Role;

import java.util.List;
/**
 * The interface that allows you to work with Role table in the data base.
 */
public interface IDAORole {
    /**
     * Method that finds all Roles in data base.
     * @return List of Roles if empty than there is no Roles in the data base.
     */
    List<Role> findAllRoles();
    /**
     * Method that finds all Roles that correspond to Role id.
     * @param id Role id.
     * @return Role if null than there is no such Role.
     */
    Role findById(long id);
    /**
     * Method that add a new Role to the data base.
     * @param role Role that you want to add.
     * @return True if Role is added successfully and false if not.
     */
    boolean addRole(Role role);
    /**
     * Method that deletes an existing Role from the data base.
     * @param role Role that you want to delete.
     * @return True if Role is deleted successfully and false if not.
     */
    boolean deleteRole(Role role);

}
