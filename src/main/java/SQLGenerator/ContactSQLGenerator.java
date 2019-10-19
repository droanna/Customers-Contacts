package SQLGenerator;

import Entity.Contact;

public class ContactSQLGenerator implements SQLGenerator<Contact> {

    @Override
    public String insert(Contact toInsert) {
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

    @Override
    public String createTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS contacts (")
                .append("ID BIGINT PRIMARY KEY AUTO_INCREMENT, ")
                .append("ID_CUSTOMER BIGINT NOT NULL, ")
                .append("TYPE INT(5) NOT NULL, ")
                .append("CONTACT VARCHAR(150))");
        return sb.toString();
    }
}
