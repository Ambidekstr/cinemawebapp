package com.anatoliivoloshyn.cinemawebapp.util;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class TransactionManager {

    private static final Connection transactionConnection = DataSource.getInstance().getConnection();
    private List<Method> methodList = new LinkedList<>();

    public void addTransaction(Method method){
        methodList.add(method);
    }

    public voi
}
