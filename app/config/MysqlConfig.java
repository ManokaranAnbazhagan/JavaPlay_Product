package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig {

    private Connection connection;
    public MysqlConfig () throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Product", "root", "Mano@2000");
        System.out.println("Successfully connected");
    }

    public Connection getConnection() {
        return connection;
    }
}

