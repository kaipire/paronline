package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<title>.:ADMIN:.</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"estilo.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"carrito_style.css\">\n");
      out.write("</head>\n");
      out.write("<body id = \"pagina\">\n");
      out.write("\t\t<header id=\"header\">\n");
      out.write("\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t<img src=\"logopar.png\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"login\">\n");
      out.write("\t\t\t\t<nav>\n");
      out.write("\t\t\t\t\t<a href=\"/paronline/Login.jsp\">Login</a>\n");
      out.write("\t\t\t\t\t<a href=\"/paronline/LoginServlet?cerrar=cerrar\">Cerrar Sesion</a>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("\t\t<div id=\"menu\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"/paronline/ClienteServlet\">Clientes</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"/paronline/CategoriaProductoServlet\">Estantes</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"/paronline/ProductoServlet\">Deposito</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"espacio\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"contenido\">\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<footer id=\"footer\">\n");
      out.write("\t\t</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
