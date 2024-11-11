<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>


<%
     try
     {
        response.setContentType("text/html");
        String uname = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String bgrp = request.getParameter("grp");
        String weight = request.getParameter("wt");
        String passwd = request.getParameter("pwd");
        String confirmPasswd = request.getParameter("confirmpwd");
        String emailid = request.getParameter("email");
        String address =request.getParameter("address");
        String mobile =request.getParameter("phno");
        String patient_id = request.getParameter("patient_id");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1232");
        PreparedStatement ps = con.prepareStatement("insert into patientRegister_table values(?,?,?,?,?,?,?,?,?,?,?)");
        
        ps.setString(1, uname);
        ps.setString(2, gender);
        ps.setString(3, age);
        ps.setString(4, bgrp);
        ps.setString(5, weight);
        ps.setString(6, passwd);
        ps.setString(7, confirmPasswd);
        ps.setString(8, emailid);
        ps.setString(9, address);
        ps.setString(10,mobile);
        ps.setString(11, patient_id);
        int n=ps.executeUpdate(); 
        if(n>0) {//out.println("Registered successfully!!");
            response.sendRedirect("loginp.html");
        }
    }
    catch(Exception e) {
        out.println("Error:"+e.getMessage());
    }
    %>
   