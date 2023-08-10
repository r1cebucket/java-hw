package server;

import java.sql.*;
// import org.postgresql.Driver;

public class UserManager {
    private Statement statement;

    public UserManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // create conn
        String url = "jdbc:postgresql://192.168.0.107:5432/chatroom";
        String user = "root";
        String password = "ricebucket";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
            this.statement.executeQuery(
                    "create table users( " +
                            "id serial, " +
                            "username varchar(64) not null unique, " +
                            "passwd varchar(256) not null, " +
                            "primary key(id));");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean login(String username, String password) {
        try {
            ResultSet resultSet = this.statement
                    .executeQuery("select passwd from users where username='" + username + "';");
            while (resultSet.next()) {
                String pwdTrue = resultSet.getString("passwd");
                if (pwdTrue.equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public boolean register(String username, String password) {
        try {
            this.statement.execute("insert into users (username, passwd) " +
                    "values ('" + username + "', '" + password + "');");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
