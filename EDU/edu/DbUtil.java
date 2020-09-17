package com.edu;

//import java.io.FileNotFoundException;

//import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                //Properties prop = new Properties();
               //InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
               // prop.load(inputStream);
               // String driver = prop.getProperty("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               // String url = prop.getProperty("jdbc:sqlserver://localhost:1433;databaseName=sun;username=sa;password=Abc123;");
               // String user = prop.getProperty("sa");
                //String password = prop.getProperty("Abc123");
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sun;username=sa;password=Abc123;");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }

    }
}