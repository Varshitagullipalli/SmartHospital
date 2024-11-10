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

@WebServlet("/PatientRegister")
public class PatientRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Fetching parameters from the form
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String bloodGroup = request.getParameter("blood_group");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        // Validating parameters
        if (!validateForm(username, email, phone, password, confirmation)) {
            out.println("<script>alert('Validation failed. Please check your inputs.');</script>");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection(); // Get database connection (implement this method)
            String query = "INSERT INTO patientRegister_table (name, gender, dob, blood_group, password, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, gender);
            ps.setString(3, dob); // Assuming you parse date appropriately
            ps.setString(4, bloodGroup);
            ps.setString(5, password);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setString(8, phone);

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
    private boolean validateForm(String username, String email, String phone, String password, String confirmation) {
        // Implement your validation logic here based on your JavaScript validation
        // For simplicity, a basic validation check is shown
        return username != null && email != null && phone != null && password != null && confirmation != null;
    }

    private void close(Connection conn, PreparedStatement ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
