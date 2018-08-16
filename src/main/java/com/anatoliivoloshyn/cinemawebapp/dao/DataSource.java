package com.anatoliivoloshyn.cinemawebapp.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {
    private static Logger logger = Logger.getLogger(DataSource.class);
    private static BasicDataSource poolOfConnections;
    private static DataSource dataSource;

    private DataSource() {
            poolOfConnections = new BasicDataSource();
            logger.info("Establishing connection pool");
            poolOfConnections.setDriverClassName("com.mysql.cj.jdbc.Driver");
            poolOfConnections.setUrl("jdbc:mysql://127.0.0.1:3306/cinema_db");
            poolOfConnections.setUsername("root");
            poolOfConnections.setPassword("root");
//            poolOfConnections.setConnectionProperties("useUnicode=true;useJDBCCompliantTimezoneShift=true;useLegacyDatetimeCode=false;serverTimezone=GMT;autoReconnect=true;useSSL=false");
            logger.info("Connection pool created");
    }

    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = poolOfConnections.getConnection();
        } catch (SQLException e) {
            logger.error("Error retrieving a connection", e);
        }
        return connection;
    }
}
