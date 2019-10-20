package DAO;

import Entity.Entity;
import java.sql.*;
import java.util.List;

public abstract class BaseDAO<T extends Entity> {

    protected static final String DB_URL = "jdbc:mysql://localhost/britenet?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    protected static final String USER = "root";
    protected static final String PASSWORD = "";
    protected String query;


    public abstract void insert(T toInsert);
    public abstract void insertAll(List<T> listToInsert);


    protected void execute() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
