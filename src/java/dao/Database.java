/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Database {
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1232");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return conn;
        }
    }
    
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        Connection conn = null;
        try {
            conn = dao.Database.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            dao.Database.close(conn);
        }
    }
}
