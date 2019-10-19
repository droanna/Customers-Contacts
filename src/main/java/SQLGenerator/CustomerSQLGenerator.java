package SQLGenerator;

import Entity.Customer;

public class CustomerSQLGenerator implements SQLGenerator<Customer> {

    @Override
    public String insert(Customer toInsert) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO customers ")
                .append("(name, surname, age) VALUES ('")
                .append(toInsert.getName())
                .append("', '")
                .append(toInsert.getSurname())
                .append("', '")
                .append(toInsert.getAge())
                .append("');");
        return sb.toString();
    }

    @Override
    public String createTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS customers (")
                .append("ID BIGINT PRIMARY KEY AUTO_INCREMENT, ")
                .append("NAME VARCHAR(100) NOT NULL, ")
                .append("SURNAME VARCHAR(100) NOT NULL, ")
                .append("AGE INT(150))");
        return sb.toString();
    }


    public String checkLast() {
        return "SELECT * FROM customers ORDER BY id DESC LIMIT 1";
    }
}
