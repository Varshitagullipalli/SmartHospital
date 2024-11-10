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

@WebServlet("/DoctorRegister")
public class DoctorRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Fetching parameters from the form
        String name = request.getParameter("name");
        String specialization = request.getParameter("specialization");
        String briefProfile = request.getParameter("profile");
        String availability = request.getParameter("availability");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Validating parameters
        if (!validateForm(name, specialization, briefProfile, availability, password, confirmation, email, phone)) {
            out.println("<script>alert('Validation failed. Please check your inputs.');</script>");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection(); // Get database connection (implement this method)
            String query = "INSERT INTO doctors (name, specialization, brief_profile, availability, password, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setString(3, briefProfile);
            ps.setString(4, availability);
            ps.setString(5, password);
            ps.setString(6, email);
            ps.setString(7, phone);

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
    private boolean validateForm(String name, String specialization, String briefProfile, String availability,
            String password, String confirmation, String email, String phone) {
        // Implement your validation logic here based on your requirements
        // For simplicity, basic checks are shown
        return name != null && specialization != null && briefProfile != null && availability != null
                && password != null && confirmation != null && email != null && phone != null
                && password.equals(confirmation);
    }

    private void close(Connection conn, PreparedStatement ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
