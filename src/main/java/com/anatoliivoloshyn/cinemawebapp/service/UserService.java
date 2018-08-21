package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOUser;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

public class UserService {
    private IDAOUser idaoUser;

    public UserService() {
        idaoUser = DAOFactory.getDAOUser();
    }

    public boolean registerUser(User user){
        return idaoUser.addUser(user);
    }
}
