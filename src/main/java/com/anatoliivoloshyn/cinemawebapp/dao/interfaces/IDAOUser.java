package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.List;

public interface IDAOUser {
    List<User> findAllUsers();
    User findUserByLogin(String login);
    User findUserById(long id);
    boolean addUser(User user);
    boolean updateUser(User updatedUser);
    boolean deleteUser(User user);
}
