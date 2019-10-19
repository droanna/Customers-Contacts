package DAO;

import Entity.Entity;

import java.sql.*;
import java.util.List;

public abstract class BaseDAO<T extends Entity> {

    private static final String DB_URL = "jdbc:mysql://localhost/britenet?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    protected String query;


    public abstract void insert(T toInsert);
    public abstract void insertAll(List<T> listToInsert);
    public abstract void createTable();

    public abstract List<T> parse(ResultSet resultSet);


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

    protected List<T> executeSelect() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<T> result = parse(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
