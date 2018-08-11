package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.List;

public interface IDAOUser {
    List<User> findAllUsers();
}
