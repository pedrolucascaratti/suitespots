/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.orient.objeto.suitespots.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class DatabaseConnection {
    private Connection connection;
    
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/?user=root&password=";
            String dbName = "suitespots";
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url);
            
            try (Statement stmt = connection.createStatement(); ResultSet resultSet = stmt.executeQuery("SHOW DATABASES LIKE '" + dbName + "'")) {
                
                if (!resultSet.next()) {
                    stmt.executeUpdate("CREATE DATABASE " + dbName);
                    System.out.println("Database criado");
                } else {
                    System.out.println("Database ja existe");
                }
                
                connection.close();
                url = "jdbc:mysql://localhost:3306/" + dbName + "?user=root&password=";
                connection = DriverManager.getConnection(url);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            System.out.println("Conectado");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
