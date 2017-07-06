package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ClienteNuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<title>.:REGISTER:.</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"login_style.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"estilo.css\">\n");
      out.write("        <script src=\"redirect.js\" language=\"javascript\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body id = \"pagina\">\n");
      out.write("\t<div id=\"contenedor\">\n");
      out.write("\t<section id=\"content_grande\">\n");
      out.write("\t\t<form action=\"/paronline/ClienteServlet\">\n");
      out.write("\t\t\t<h1>Registro</h1>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"text\" placeholder=\"Nombre\" id=\"username\" name=\"nombre\" required/>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"text\" placeholder=\"Apellido\" id=\"username\" name=\"apellido\"required=\"\"/>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"number\" placeholder=\"Cedula\" id=\"username\" name=\"cedula\"required=\"\"/>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"email\" placeholder=\"Email\" id=\"username\" name=\"email\" required/>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"Password\" id=\"password\" name=\"cont\" required/>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"vaccion\" value=\"Registrar\"/>\n");
      out.write("                                <input type=\"submit\" value=\"Registrar\" />\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"Atras\" onclick=\"javascript:ir_a_login()\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</section>\n");
      out.write("\t</div>\n");
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
