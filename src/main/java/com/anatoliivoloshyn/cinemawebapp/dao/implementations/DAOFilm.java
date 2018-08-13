package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOFilm implements IDAOFilm {
    private final String SELECT_ALL = "Select * from `film`";
    private final String SELECT_BY_ID = "Select * from `film` where `film_id` = ?";
    private final String ADD_FILM = "Insert into `film`(`film_name`, `director`, `duration`, `poster`, `trailer`, `age_restriction`) values (?,?,?,?,?,?)";
    private final String UPDATE_FILM = "Update `film` set `film_name` = ?, `director` = ?, `duration` = ?, `poster` = ?, `trailer` = ?, `age_restriction` = ?, where `film_id` = ?";
    private final String DELETE_FILM = "Delete from `film` where `film_id` = ?";
    private List<Film> filmList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Film film;

    @Override
    public List<Film> findAllFilms() {
        filmList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                film = new Film(
                        resultSet.getLong("film_id"),
                        resultSet.getString("age_restriction"),
                        resultSet.getString("film_name"),
                        resultSet.getString("director"),
                        resultSet.getString("poster"),
                        resultSet.getString("trailer"),
                        resultSet.getTime("duration"));
                filmList.add(film);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return filmList;
    }

    @Override
    public Film findById(long id) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            film = new Film(
                    resultSet.getLong("film_id"),
                    resultSet.getString("age_restriction"),
                    resultSet.getString("film_name"),
                    resultSet.getString("director"),
                    resultSet.getString("poster"),
                    resultSet.getString("trailer"),
                    resultSet.getTime("duration"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public boolean addFilm(Film filmToAdd) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_FILM);
            preparedStatement.setString(1, filmToAdd.getFilmName());
            preparedStatement.setString(2,filmToAdd.getDirector());
            preparedStatement.setTime(3,filmToAdd.getDuration());
            preparedStatement.setString(4,filmToAdd.getPoster());
            preparedStatement.setString(5,filmToAdd.getTrailerPath());
            preparedStatement.setString(6,filmToAdd.getAgeRestriction());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFilm(Film filmToDelete) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_FILM);
            preparedStatement.setLong(1,filmToDelete.getFilmId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateFilm(Film filmToUpdate, Film updatedFilm) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(UPDATE_FILM);
            preparedStatement.setString(1, updatedFilm.getFilmName());
            preparedStatement.setString(2,updatedFilm.getDirector());
            preparedStatement.setTime(3,updatedFilm.getDuration());
            preparedStatement.setString(4,updatedFilm.getPoster());
            preparedStatement.setString(5,updatedFilm.getTrailerPath());
            preparedStatement.setString(6,updatedFilm.getAgeRestriction());
            preparedStatement.setLong(7,filmToUpdate.getFilmId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
