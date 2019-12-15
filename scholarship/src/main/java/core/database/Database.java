package core.database;

import core.notation.Configuration;

import java.sql.*;

import static java.lang.Class.forName;

@Configuration
public class Database {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "mohmmad";

    static final String PASS = "moh2079saf";
    private static Connection connection;

    public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } else {
            if (connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        }
        return connection;
    }
}
