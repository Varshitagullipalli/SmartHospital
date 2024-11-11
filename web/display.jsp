<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
    <title>Patient Details</title>
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
            margin: 0 auto; /* Center the table */
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
    <h1>Patient Details</h1>

    <%
       
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String grp = request.getParameter("grp");
        String wt = request.getParameter("wt");
        String pwd = request.getParameter("pwd");
        String confirmpwd = request.getParameter("confirmpwd");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phno = request.getParameter("phno");
        String patient_id = request.getParameter("patient_id");
    Connection con = null;
    try {
       
         response.setContentType("text/html");
        // Check if any parameter is null or empty
        if (name == null || gender == null || age == null || grp == null || wt == null || 
            pwd == null || confirmpwd == null || email == null || address == null || 
            phno == null || patient_id == null) {
            throw new Exception("All parameters are required.");
        }

        // Check if passwords match
        if (!pwd.equals(confirmpwd)) {
            throw new Exception("Passwords do not match.");
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1232");

        String sql = "INSERT INTO patientRegister_table (name, gender, age, grp, wt, pwd, confirmpwd, email, address, phno, patient_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, gender);
        ps.setString(3, age);
        ps.setString(4, grp);
        ps.setString(5, wt);
        ps.setString(6, pwd);
        ps.setString(7, confirmpwd);
        ps.setString(8, email);
        ps.setString(9, address);
        ps.setString(10, phno);
        ps.setString(11, patient_id);

        int n = ps.executeUpdate();
        if (n > 0) {
            //out.println("Registration successful!");
           
        } 
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
       
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    %>

    <table>
        <tbody>
            <tr>
                <td>Name:</td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><%=gender%></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><%=age%></td>
            </tr>
            <tr>
                <td>Blood Group:</td>
                <td><%=grp%></td>
            </tr>
            <tr>
                <td>Weight in kg:</td>
                <td><%=wt%></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><%=email%></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><%=address%></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><%=phno%></td>
            </tr>
            <tr>
                <td>Patient Id:</td>
                <td><%=patient_id%></td>
            </tr>
        </tbody>
    </table><br><br>
            <input type="button" value="Click here to Login" style="padding: 10px 20px; /* Increase padding (top/bottom, left/right) */
  font-size: 18px; /* Increase font size */
  background-color:#fffff;margin-left:650px" onclick="window.location.href='loginp.html'">
</body>
</html>
