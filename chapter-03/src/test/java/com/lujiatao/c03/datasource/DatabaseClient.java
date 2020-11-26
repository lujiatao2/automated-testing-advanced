package com.lujiatao.c03.datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DatabaseClient {

    private String url;
    private Connection connection = null;
    private Statement statement = null;

    public DatabaseClient(String driver, String url) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        if (url != null && !url.equals("")) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("数据库URL为空！");
        }
    }

    public void connect(String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
                statement = null;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<LinkedHashMap<String, Object>> queryData(String sql) {
        List<LinkedHashMap<String, Object>> result = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> columns = getColumns(resultSet);
            LinkedHashMap<String, Object> linkedHashMap;
            while (resultSet.next()) {
                linkedHashMap = new LinkedHashMap<>();
                for (String column : columns) {
                    linkedHashMap.put(column, resultSet.getObject(column));
                }
                result.add(linkedHashMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    private List<String> getColumns(ResultSet resultSet) {
        List<String> result = new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                result.add(resultSetMetaData.getColumnName(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    public int modifyData(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
