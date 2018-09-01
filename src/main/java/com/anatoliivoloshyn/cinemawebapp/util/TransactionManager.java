package com.anatoliivoloshyn.cinemawebapp.util;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TransactionManager {

    private static final Connection transactionConnection = DataSource.getInstance().getConnection();
    private List<Method> methodList = new LinkedList<>();
    private Map<Integer, Object> arguments = new HashMap<>();
    private Integer count = 1;

    public void addTransaction(Method method, Object object, Object...args){
        try {
            transactionConnection.setAutoCommit(false);
            Field field = method.getClass().getField("connection");
            field.setAccessible(true);
            field.set(object,transactionConnection);
            methodList.add(method);
            arguments.put(count++,args);
        } catch (IllegalAccessException | NoSuchFieldException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Method> getTransactions(){
        return methodList;
    }

    public boolean commit(){
        return true;
    }

    public boolean rollBack(){
 return true;
    }

}
