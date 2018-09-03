package com.anatoliivoloshyn.cinemawebapp.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {
    private static Logger logger = Logger.getLogger(DataSource.class);
    private static BasicDataSource poolOfConnections = new BasicDataSource();
    private static DataSource dataSource = new DataSource();
    private Connection connection;

    private DataSource() {
            logger.info("Establishing connection pool");
            poolOfConnections.setDriverClassName("com.mysql.cj.jdbc.Driver");
            poolOfConnections.setUrl("jdbc:mysql://127.0.0.1:3306/cinema_db?useUnicode=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Kiev");
            poolOfConnections.setUsername("root");
            poolOfConnections.setPassword("1234");
            logger.info("Connection pool created");
    }

    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        try {
            connection = poolOfConnections.getConnection();
        } catch (SQLException e) {
            logger.error("Error retrieving a connection", e);
        }
        return connection;
    }
}
