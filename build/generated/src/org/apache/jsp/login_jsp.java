package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Login</title>\n");
      out.write("    <style>\n");
      out.write("        .avatar {\n");
      out.write("            width: 100px;\n");
      out.write("            height: 100px;\n");
      out.write("            border-radius: 50%;\n");
      out.write("            background-image: url(nurse.avif);\n");
      out.write("            background-size: cover;\n");
      out.write("            border: 2px solid #ccc;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .login-form {\n");
      out.write("            width: 300px;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .form-group {\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        .form-group label {\n");
      out.write("            display: block;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .form-group input {\n");
      out.write("            width: 95%;\n");
      out.write("            padding: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 3px;\n");
      out.write("        }\n");
      out.write("        .form-group button {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 8px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 3px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-image: url('homepic.jpg');background-repeat:no\">\n");
      out.write("\n");
      out.write("        <div class=\"avatar\"></div>\n");
      out.write("        <div class=\"login-form\">\n");
      out.write("            <form action = \"login.java\" method = \"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"userid\">UserID:</label>\n");
      out.write("                    <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Password:</label>\n");
      out.write("                    <input type=\"password\" id=\"password\" name=\"password\" required><br><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <input  type=\"submit\" value=\"Login\" style=\"border-radius: 50px;width: 100px;position: relative;left: 100px;\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
