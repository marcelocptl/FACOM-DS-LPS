/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rick_
 */
public class ConnectFactory {
    
    private static String db, schema, user, password;
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://"+db+"/"+schema, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDb(String db) {
        ConnectFactory.db = db;
    }

    public static void setSchema(String schema) {
        ConnectFactory.schema = schema;
    }

    public static void setUser(String user) {
        ConnectFactory.user = user;
    }

    public static void setPassword(String password) {
        ConnectFactory.password = password;
    }
    
    

}
