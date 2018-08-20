package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOUser;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import org.apache.log4j.Logger;

public class LoginService {
    private static Logger logger = Logger.getLogger(LoginService.class);
    public User login(String login, String pass){
        IDAOUser daoUser = DAOFactory.getDAOUser();
        User user = daoUser.findUserByLogin(login);
        if(user != null){
            if(user.getPassword().equals(pass)){
                return user;
            }
            return null;
        }
        logger.warn("Wrong password");
        return null;
    }
}
