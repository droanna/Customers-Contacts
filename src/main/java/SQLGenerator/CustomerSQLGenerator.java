package SQLGenerator;

public class CustomerSQLGenerator implements SQLGenerator{

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

}
