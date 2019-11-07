package SQLGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseGenerator {


    private static final String USER = "root";
    private static final String PASSWORD = "";
    protected String query;


    public void createDatabaseStructure(){
        CustomerSQLGenerator customerSQLGenerator = new CustomerSQLGenerator();
        ContactSQLGenerator contactSQLGenerator = new ContactSQLGenerator();
        createDataBase();
        createTable(customerSQLGenerator);
        createTable(contactSQLGenerator);
    }

    public void createDataBase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", USER, PASSWORD);
            Statement statement = connection.createStatement();
            query = "CREATE database IF NOT EXISTS customers-contacts";
            statement.execute(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T extends SQLGenerator> void  createTable(T t){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/britenet?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(t.createTable());
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
