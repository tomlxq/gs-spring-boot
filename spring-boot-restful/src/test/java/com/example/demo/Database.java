package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    private Connection con;

    public void connect() throws Exception{

        if(con != null) return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("No database");
        }
        Properties properties = new Properties();
        properties.setProperty("user", "springbootdb");
        properties.setProperty("password", "123456");
        properties.setProperty("useSSL", "true");
        properties.setProperty("autoReconnect", "true");
        String connectionURL = "jdbc:mysql://localhost:3306/springbootdb?useUnicode=true&characterEncoding=utf8";

        con = DriverManager.getConnection(connectionURL, properties);
    }

    public void close(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}