<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment Successful</title>
        
     <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px; /* Add padding to the body to give some space around the content */
            }
            h1 {
                text-align: center;
                margin-bottom: 20px;
            }
            table {
                border-collapse: collapse;
                width: 50%;
                background-color: #fff;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
                font-weight: bold;
            }
            tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            td:first-child {
                width: 30%; /* Adjust this value as needed */
                font-weight: bold; /* Optional: make the labels bold for better distinction */
            }
            td:last-child {
                width: 70%; /* Adjust this value as needed */
            }
        </style>

    </head>
    <body>
        <h1 style="text-align:center;">Appointment Successful</h1>
        
        <% 
            String patient_id = request.getParameter("patient_id");
            String patient_name = request.getParameter("patient_name");
            String patient_phone = request.getParameter("patient_phone");
            String doctor = request.getParameter("doctor");
            String prefer_date = request.getParameter("prefer_date");
            String prefer_time = request.getParameter("prefer_time");
            String remarks = request.getParameter("remarks");
           
     try
     {
        response.setContentType("text/html");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1232");
        PreparedStatement ps = con.prepareStatement("insert into appointment_table values(?,?,?,?,?,?,?)");
        
        ps.setString(1, patient_id);
        ps.setString(2, patient_name);
        ps.setString(3, patient_phone);
        ps.setString(4, doctor);
        ps.setString(5, prefer_date);
        ps.setString(6,prefer_time);
        ps.setString(7, remarks);
        int n=ps.executeUpdate(); 
        if(n>0) {
           // out.println("Registered successfully!!");
            //response.sendRedirect("appointment.jsp");
        }
    }
    catch(Exception e) {
        out.println("Error:"+e.getMessage());
    }
 

            
        %>
        <table border="1" align = "center">
           
            <tbody>
                <tr>
                    <td>Patient_id:</td>
                    <td><%=patient_id%></td>
                </tr>
                <tr>
                    <td>Patient Name:</td>
                    <td><%=patient_name%></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><%=patient_phone%></td>
                </tr>
                <tr>
                    <td>Preferred Doctor:</td>
                    <td><%=doctor%></td>
                </tr>
                <tr>
                    <td>Preferred Date:</td>
                    <td><%=prefer_date%></td>
                </tr>
                <tr>
                    <td>Preferred Time:</td>
                    <td><%=prefer_time%></td>
                </tr>
                <tr>
                    <td>Problem:</td>
                    <td><%=remarks%></td>
                </tr>
            </tbody>
        </table><br><br>
                <img src ="qr1.png" alt =" qr code" style ="display: block;
                margin: 20px auto;">  
                <p style="text-align:center">Scan here for Patient Details</p>
    </body>
</html>

