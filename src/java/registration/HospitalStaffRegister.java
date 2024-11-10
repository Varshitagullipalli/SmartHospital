/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static dao.Database.*; // Assuming you have a Database class for connection management

@WebServlet("/HospitalStaffRegister")
public class HospitalStaffRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Fetching parameters from the form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        int experience = Integer.parseInt(request.getParameter("experience"));
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");

        // Validating parameters
        if (!validateForm(name, email, phone, department, experience, password, confirmation)) {
            out.println("<script>alert('Validation failed. Please check your inputs.');</script>");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection(); // Get database connection (implement this method)
            String query = "INSERT INTO hospital_staff (name, email, phone, department, experience, password) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, department);
            ps.setInt(5, experience);
            ps.setString(6, password);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<script>alert('Registration successful!');</script>");
            } else {
                out.println("<script>alert('Registration failed. Please try again later.');</script>");
            }
        } catch (SQLException e) {
            out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
        } finally {
            close(conn, ps); // Implement close method to close connection and statement
            out.close();
        }
    }

    // Method to validate form inputs
    private boolean validateForm(String name, String email, String phone, String department, int experience,
            String password, String confirmation) {
        // Implement your validation logic here based on your requirements
        // For simplicity, basic checks are shown
        return name != null && email != null && phone != null && department != null && experience > 0
                && password != null && confirmation != null && password.equals(confirmation);
    }

    private void close(Connection conn, PreparedStatement ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

