package com.anatoliivoloshyn.cinemawebapp.dao;

import com.anatoliivoloshyn.cinemawebapp.util.PropertyHolder;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {

    private static ComboPooledDataSource poolOfConnections;
    private static DataSource dataSource;

    private DataSource() {
        poolOfConnections = new ComboPooledDataSource();
        PropertyHolder propertyHolder = PropertyHolder.getInstance();
        try {
            poolOfConnections.setDriverClass(propertyHolder.getDbDriver());

            poolOfConnections.setJdbcUrl(propertyHolder.getJdbcUrl());
            poolOfConnections.setUser(propertyHolder.getDbUserLogin());
            poolOfConnections.setPassword(propertyHolder.getDbUserPassword());

            poolOfConnections.setMinPoolSize(10);
            poolOfConnections.setAcquireIncrement(1);
            poolOfConnections.setMaxPoolSize(100);
        } catch (PropertyVetoException e) {
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
