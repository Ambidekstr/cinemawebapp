package com.anatoliivoloshyn.cinemawebapp.dao;

import com.anatoliivoloshyn.cinemawebapp.util.PropertyHolder;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {

    private static BasicDataSource poolOfConnections = new BasicDataSource();
    private static DataSource dataSource = new DataSource();

    private DataSource() {
        try {
            poolOfConnections.setDriverClassName("com.mysql.cj.jdbc.Driver");

            poolOfConnections.setUrl("jdbc:mysql://localhost:3306/cinema_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT");
            poolOfConnections.setUsername("root");
            poolOfConnections.setPassword("1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            e.printStackTrace();
        }
        return connection;
    }
}
