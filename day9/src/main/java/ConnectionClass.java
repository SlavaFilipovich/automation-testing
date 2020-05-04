import java.sql.*;

class ConnectionClass {
    private Connection connection;

    private final static String URL = "jdbc:mysql://localhost:3306/megaapp" +
            "?allowPublicKeyRetrieval=true"+
   //         "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "bbcdotcom2020";

    ConnectionClass() throws SQLException {
        this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    Connection getConnection() {
        return connection;
    }

    static void executePreparedStatement(String query, Connection connection){
        try(PreparedStatement statement = connection.prepareStatement(query)){
            for (int i = 1; i <= 10; i++) {
                statement.setString(1,LogPassGenerate.generateLogin());
                statement.setString(2,LogPassGenerate.generatePassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void executeStatement(String initialQuery,String dropQuery,String createQuery, Connection connection){
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(initialQuery)){
            if(rs.next()){
                statement.executeUpdate(dropQuery);
                statement.executeUpdate(createQuery);
            }
            else statement.executeUpdate(createQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

