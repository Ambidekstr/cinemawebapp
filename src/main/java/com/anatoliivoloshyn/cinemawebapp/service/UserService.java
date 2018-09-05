package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOUser;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import org.apache.log4j.Logger;
/**
 * Service class that is responsible for work with Users
 */
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);
    private IDAOUser idaoUser;

    public UserService() {
        idaoUser = DAOFactory.getDAOUser();
    }
    /**
     * Method that register a new User.
     * @param user User you want to register.
     * @return True if User is added successfully and false if not.
     */
    public boolean registerUser(User user){
        return idaoUser.addUser(user);
    }
    /**
     * Method that verify information from user based on data base.
     * @param login Login name.
     * @param pass Password.
     * @return Corresponding User if null than there is no such User or the params are wrong.
     */
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
