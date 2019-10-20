package SQLGenerator;

public class ContactSQLGenerator implements SQLGenerator {

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
