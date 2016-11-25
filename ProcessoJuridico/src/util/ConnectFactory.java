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
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
