package DAO;

import Entity.Customer;
import SQLGenerator.CustomerSQLGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO extends BaseDAO<Customer> {

    private CustomerSQLGenerator customerSQLGenerator = new CustomerSQLGenerator();

    @Override
    public void insert(Customer customer) {
        query = customerSQLGenerator.insert(customer);
        execute();
        query = customerSQLGenerator.checkLast();
        List<Customer> result = executeSelect();
        customer.setId(result.get(0).getId());
    }

    @Override
    public void createTable() {
        query = customerSQLGenerator.createTable();
        execute();
    }

    @Override
    public List<Customer> parse(ResultSet resultSet) {
        List<Customer> result = new ArrayList<>();
        try {
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                result.add(new Customer(id, name, surname, age));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertAll(List<Customer> listToInsert) {
        for(Customer c: listToInsert){
            insert(c);
        }
    }
}
