package DAO;

import Entity.Contact;
import java.util.List;

public class ContactDAO extends BaseDAO<Contact> {


    @Override
    public void insert(Contact contact) {
        query = insertQuery(contact);
        execute();
    }

    @Override
    public void insertAll(List<Contact> listToInsert) {
        for (Contact c: listToInsert){
            insert(c);
        }
    }

    public String insertQuery(Contact toInsert) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO contacts (id_customer, type, contact) VALUES ('")
                .append(toInsert.getCustomer().getId())
                .append("', '")
                .append(toInsert.getType())
                .append("', '")
                .append(toInsert.getContact())
                .append("');");
        return sb.toString();
    }

}
