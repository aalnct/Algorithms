package javacertification.concurrentandjdbc;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    public static void main(String[] args) throws SQLException {
        String url = "";
        Properties prop = new Properties();
        prop.put("username", "username");
        prop.put("password", "password");

        try {
            Connection connection = DriverManager.getConnection(url,prop);
            ResultSet resultSet = null;

            // relative will move cursor n number of rows from
            // the current position
            resultSet.relative(1);
        }catch (Exception exception) {

        }

        try (Connection con = DriverManager.getConnection(url, prop);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("query");) {

        }

    }
}
