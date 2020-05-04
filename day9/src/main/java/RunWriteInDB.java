import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RunWriteInDB {

    public static void main(String[] args) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String initialQuery = "SELECT * FROM users";
        String dropQuery = "DROP TABLE users";
        String createQuery = "CREATE TABLE IF NOT EXISTS users (user_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "user_login varchar(255) NOT NULL, " +
                "user_password varchar(40) NOT NULL)";

        ConnectionClass.executeStatement(initialQuery, dropQuery, createQuery, connection);
        String addToTableQuery = "INSERT INTO users (user_login, user_password) VALUES(?,?)";
        ConnectionClass.executePreparedStatement(addToTableQuery, connection);
        printUsers(initialQuery, connection);
    }

    private static void printUsers(String query, Connection connection) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }
}
