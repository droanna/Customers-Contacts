package DAO;

import Entity.Contact;
import SQLGenerator.ContactSQLGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO extends BaseDAO<Contact> {

    private ContactSQLGenerator contactSQLGenerator = new ContactSQLGenerator();

    @Override
    public void insert(Contact contact) {
        query = contactSQLGenerator.insert(contact);
        execute();
    }

    @Override
    public void createTable() {
        query = contactSQLGenerator.createTable();
        execute();
    }

    @Override
    public List<Contact> parse(ResultSet resultSet) {
        List<Contact> result = new ArrayList<>();
        try {
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                long customerID = resultSet.getLong("id_customer");
                int type = resultSet.getInt("type");
                String contact = resultSet.getString("contact");
                result.add(new Contact(id, customerID, type, contact));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertAll(List<Contact> listToInsert) {
        for (Contact c: listToInsert){
            insert(c);
        }
    }
}
