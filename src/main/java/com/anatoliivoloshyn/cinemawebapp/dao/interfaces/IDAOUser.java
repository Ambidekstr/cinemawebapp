package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.List;
/**
 * The interface that allows you to work with User table in the data base.
 */
public interface IDAOUser {
    /**
     * Method that finds all Users in data base.
     * @return List of Users if empty than there is no Users in the data base.
     */
    List<User> findAllUsers();
    /**
     * Method that finds User that correspond to User login.
     * @param login User login.
     * @return User if null than there is no such User.
     */
    User findUserByLogin(String login);
    /**
     * Method that finds User that correspond to User id.
     * @param id User id.
     * @return User if null than there is no such User.
     */
    User findUserById(long id);
    /**
     * Method that add a new User to the data base.
     * @param user User that you want to add.
     * @return True if User is added successfully and false if not.
     */
    boolean addUser(User user);
    /**
     * Method that updates an existing User in the data base.
     * @param updatedUser Updated User.
     * @return True if User is updated successfully and false if not.
     */
    boolean updateUser(User updatedUser);
    /**
     * Method that deletes an existing User from the data base.
     * @param user User that you want to delete.
     * @return True if User is deleted successfully and false if not.
     */
    boolean deleteUser(User user);
}
