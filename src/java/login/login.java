/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static dao.Database.*;

/**
 *
 * @author Admin
 */
public class login {

    private String user_uid;
    private String user_pwd;
    private String user_name;

    login(String user_uid, String user_pwd) {
        this.user_uid = user_uid;
        this.user_pwd = user_pwd;
    }

    public boolean loginvalidate() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean login_ind = false;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("select user_name from login_table where user_uid=? and user_pwd=?");
            ps.setString(1, this.user_uid);
            ps.setString(2, this.user_pwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                login_ind = true;
                this.user_name = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            close(conn);
            return login_ind;
        }
    }

    public String getNmae() {
        return this.user_name;
    }

    public static void main(String args[]) {
        login login_obj = null;
        boolean login_ind = false;

        try {
            login_obj = new login("admin", "adminpwd1");
            login_ind = login_obj.loginvalidate();
            if (login_ind) {
                System.out.println("login successful, Welcome " + login_obj.getNmae());
            } else {
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            login_obj = null;
        }
    }
}

