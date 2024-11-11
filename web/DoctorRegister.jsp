<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>

<%
    try
    {
     response.setContentType("text/html");
     String uname=request.getParameter("name");
     String specialization = request.getParameter("specialization");
     String brief_profile = request.getParameter("brief_profile");
     String availability = request.getParameter("availability");
     String passwd=request.getParameter("passwd");
     String confirmpasswd=request.getParameter("confirmpasswd");
     String emailid=request.getParameter("email");
     String phno=request.getParameter("phno");
     Class.forName("oracle.jdbc.driver.OracleDriver");
     //out.println("Driver Loaded...");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1232");
     //out.println("Connected to database");
     PreparedStatement ps=con.prepareStatement("insert into doctorRegister_table values(?,?,?,?,?,?,?,?)");
     ps.setString(1,uname);
     ps.setString(2,specialization);
     ps.setString(3,brief_profile);
     ps.setString(4,availability);
     ps.setString(5,passwd);
     ps.setString(6,confirmpasswd); 
     ps.setString(7,emailid);
     ps.setString(8,phno);
     int n=ps.executeUpdate(); 
    if(n>0) {//out.println("Registered successfully!!");
    response.sendRedirect("logind.html");
    }
    }
    catch(Exception e)
    {
    out.println("Error is:"+e);
    }
   %>
  


  