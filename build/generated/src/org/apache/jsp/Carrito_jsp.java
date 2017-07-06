package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import conexion.TransaccionCabConexion;
import conexion.ClienteConexion;
import modelo.Cliente;
import modelo.Usuario;
import modelo.TransaccionDet;
import modelo.TransaccionCab;
import modelo.Carrito;
import java.util.ArrayList;

public final class Carrito_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("            <meta charset=\"UTF-8\">\n");
      out.write("            <title>.:CARRITO:.</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"carrito_style.css\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"estilo.css\">\n");
      out.write("            <script src=\"redirect.js\" language=\"javascript\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body id = \"pagina\">\n");
      out.write("\t<div id=\"contenedor\">\n");
      out.write("            <section id=\"content_tablita\">\n");
      out.write("\t\t<h1>Carrito</h1>\n");
      out.write("\t\t<div>\n");
      out.write("                    <table id=\"table2\" style=\"width:80%; margin-left:10%\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>Descripcion</th>\n");
      out.write("                            <th>Precio</th>\n");
      out.write("                            <th>Cantidad</th>\n");
      out.write("                            <th>Accion</th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");

                            ArrayList<Carrito> carrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");
                            int monto_total=0;
                            HttpSession hs = request.getSession();
                            if (carrito != null) {
                                for (Carrito c : carrito) {
                        
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("                            ");
monto_total = monto_total + (c.getProducto().getPrecio() * c.getCantidad());
      out.write("\n");
      out.write("                            <td>");
      out.print(c.getProducto().getId_producto());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(c.getProducto().getDescripcion());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(c.getProducto().getPrecio());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(c.getCantidad());
      out.write("</td>\n");
      out.write("                            <td style=\"width:80px\">\n");
      out.write("                                <form action=\"/paronline/CarritoServlet\" method=\"post\"> \n");
      out.write("                                    <input type=\"hidden\" name=\"quitar\" value=\"quitar\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"vid\" value=\"");
      out.print(c.getProducto().getId_producto());
      out.write("\"/>\n");
      out.write("                                    <input type=\"submit\" id=\"add\"value=\"Quitar\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");
 } }
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("                            <td colspan=\"5\" style=\"background-color:white; color: #7E7E7E; border: 3px solid rgba(254,193,81,1);font-size: 15px;font-weight:bold\">Total a pagar:");
      out.print(monto_total);
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");

                            hs.setAttribute("monto_total",monto_total);
                        
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <section id=\"content\">\n");
      out.write("\t\t<form action=\"/paronline/TransaccionServlet\" method=\"post\">\n");
      out.write("                    <h1>Pago & Envio</h1>\n");
      out.write("                    <div>\n");
      out.write("                        <div style=\"text-align: left\">\n");
      out.write("                            <h4>Forma de Pago</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div style=\"text-align: left; margin: 0px 0px 20px 20px\">\n");
      out.write("                            <input type=\"radio\" id=\"radio01\" name=\"efectivo\" />\n");
      out.write("                            <label for=\"radio01\"><span></span>Efectivo</label>\n");
      out.write("                            <input type=\"radio\" id=\"radio02\" name=\"tarjeta\" />\n");
      out.write("                            <label for=\"radio02\"><span></span>Tarjeta</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"text\" placeholder=\"Nro de Tarjeta\" required=\"\" id=\"username\" name=\"tarjeta\" disabled/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"text\" placeholder=\"Direccion de Envio\" id=\"username\" name=\"direccion\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"hidden\" name=\"confirmar\" value=\"confirmar\"/> \n");
      out.write("                        <input type=\"submit\" value=\"Confirmar\" />\n");
      out.write("                        <input type=\"hidden\" name=\"cancelar\" value=\"cancelar\"/> \n");
      out.write("                        <input type=\"submit\" value=\"Cancelar\" />\n");
      out.write("                    </div>\n");
      out.write("                </form><!-- form -->\n");
      out.write("            </section><!-- content -->\n");
      out.write("\t</div>\n");
      out.write("    </body>\n");
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
