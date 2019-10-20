package DAO;

import Entity.Customer;
import java.sql.*;
import java.util.List;


public class CustomerDAO extends BaseDAO<Customer> {


    @Override
    public void insert(Customer customer) {
        query = "INSERT INTO customers (name, surname, age) VALUES (?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            if(customer.getAge()!=0){
                statement.setInt(3, customer.getAge());
            } else{
                statement.setNull(3, Types.INTEGER);
            }
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                customer.setId(generatedKeys.getLong(1));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insertAll(List<Customer> listToInsert) {
        for(Customer c: listToInsert){
            insert(c);
        }
    }
}
