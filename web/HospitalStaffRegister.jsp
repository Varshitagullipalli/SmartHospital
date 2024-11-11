<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%
try {
    response.setContentType("text/html");
    String uname = request.getParameter("name");    
    String emailid = request.getParameter("email");
    String mobile = request.getParameter("phno");
    String department = request.getParameter("department");
    String exp = request.getParameter("experience");
    String passwd = request.getParameter("passwd");
    String confirmPasswd = request.getParameter("confirmpasswd");
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1232");
    PreparedStatement ps = con.prepareStatement("INSERT INTO hospitalStaffRegister_table (name, email, phno, department, experience, passwd, confirmpasswd) VALUES (?, ?, ?, ?, ?, ?, ?)");
    
    ps.setString(1, uname);
    ps.setString(2, emailid);
    ps.setString(3, mobile);
    ps.setString(4, department);
    ps.setString(5, exp);
    ps.setString(6, passwd);
    ps.setString(7, confirmPasswd);
    
    int n = ps.executeUpdate(); 
    if (n > 0) {
        response.sendRedirect("loginh.html"); // Redirect after successful registration
    }
} catch(Exception e) {
    out.println("Error: " + e.getMessage());
}
%>
