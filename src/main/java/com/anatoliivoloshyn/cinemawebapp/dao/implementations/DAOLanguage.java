package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOLanguage;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOLanguage implements IDAOLanguage {
    private final String SELECT_ALL = "Select * from `language`";
    private final String SELECT_BY_ID = "Select * from `language` where `language_id` = ?";
    private final String ADD_LANGUAGE = "Insert into `language`(`language`) values (?)";
    private final String DELETE_LANGUAGE = "Delete from `language` where `language_id` = ?";
    private List<Language> languageList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Language languageDao;

    @Override
    public List<Language> findAllLanguages() {
        languageList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                languageDao = new Language(
                        resultSet.getLong("language_id"),
                        resultSet.getString("language"));
                languageList.add(languageDao);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return languageList;
    }

    @Override
    public Language findLanguageById(long id) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            languageDao = new Language(
                    resultSet.getLong("language_id"),
                    resultSet.getString("language"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return languageDao;
    }

    @Override
    public boolean addLanguage(Language language) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_LANGUAGE);
            preparedStatement.setString(1,language.getLanguage());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteLanguage(Language language) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_LANGUAGE);
            preparedStatement.setLong(1,language.getLanguageId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
