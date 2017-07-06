package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Producto;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<title>.:HOME:.</title>\n");
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
      out.write("\t\t\t\t<li><a href=\"/paronline/CarritoServlet?confirmar=conf_carrito\">Carrito</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"/paronline/HistorialCliente.jsp\">Historial</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"\">Categorias ></a>\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/paronline/FiltroProductoServlet?cat=1\">Deportes</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/paronline/FiltroProductoServlet?cat=2\">Rol</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/paronline/FiltroProductoServlet?cat=3\">Shooter</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"espacio\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"contenido\">\n");
      out.write("\t\t\t\t<section id=\"content_tablita\">\n");
      out.write("\t\t\t\t\t<form action=\"/paronline/CarritoServlet\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t<h1>Bienvenido</h1>\n");
      out.write("\t\t\t\t\t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<table id=\"table2\" style=\"width:80%; margin-left:10%\">\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>ID</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Descripcion</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>Cantidad</th>\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("                                                                ");

                                                                    //aca vamos a poner al getALL() de producto y que vaya listando
                                                                    ArrayList<Producto> p1 = (ArrayList<Producto>) request.getAttribute("array_producto");

                                                                    if (p1 != null) {
                                                                        for (Producto p : p1) {
                                                                
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print(p.getId_producto());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print(p.getDescripcion());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"width: 150px\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" id=\"add\"value=\"Add\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"\" required=\"\" id=\"cantidad\" name=\"cantidad\"/>\n");
      out.write("                                                                                <input type=\"hidden\" name=\"vaccion\" value=\"agregar_carrito\"/>\n");
      out.write("                                                                                <input type=\"hidden\" name=\"vid\" value=\"");
      out.print(p.getId_producto());
      out.write("\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("                                                                ");
 } }
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form><!-- form -->\n");
      out.write("\t\t\t\t</section>\n");
      out.write("\t\t\t\t<section id=\"content\">\n");
      out.write("\t\t\t\t\t<form action=\"/paronline/FiltroProductoServlet\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t<h1>Busqueda</h1>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"Ingrese nombre de producto\" required=\"\" id=\"username\" name=\"descripcion\"/>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"Buscar\" />\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</section>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<footer id=\"footer\">\n");
      out.write("\t\t</footer>\n");
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
