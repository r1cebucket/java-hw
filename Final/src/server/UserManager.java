package server;

import java.sql.*;
import org.postgresql.Driver;

public class UserManager {
    private Statement statement;

    public UserManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // create conn
        String url = "jdbc:postgresql://192.168.0.107:5432/chat";
        String user = "root";
        String password = "ricebucket";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            this.statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean login(String username, String password) {
        try {
            ResultSet resultSet = this.statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
