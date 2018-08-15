package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOUser;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

public class LoginService {
    public boolean login(String login, String pass){
        IDAOUser daoUser = DAOFactory.getDAOUser();
        User user = daoUser.findUserByLogin(login);
        if(user != null){
            return user.getPassword().equals(pass);
        }
        return false;
    }
}
