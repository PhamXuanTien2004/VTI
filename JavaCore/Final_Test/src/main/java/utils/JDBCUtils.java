package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName("com.mysql.cj.jdbc.Driver");

        return  DriverManager.getConnection(url, user, password);

    }
}
