package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.List;

public interface IDAOUser {
    List<User> findAllUsers();
    User findUserByLogin(String login);
    List<User> findUserByRole(String role);
    boolean addUser(User user);
    boolean updateUser(User userToUpdate, User updatedUser);
    boolean deleteUser(User user);
    boolean deleteUserByLogin(String login);
}
