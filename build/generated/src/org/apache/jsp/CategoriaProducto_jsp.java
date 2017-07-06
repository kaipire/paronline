package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.CategoriaProducto;
import java.util.ArrayList;

public final class CategoriaProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("            <meta charset=\"UTF-8\">\n");
      out.write("            <title>.:LIST_CAT:.</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"carrito_style.css\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"estilo.css\">\n");
      out.write("    </head>\n");
      out.write("    <body id = \"pagina\">\n");
      out.write("\t<div id=\"contenedor\">\n");
      out.write("            <section id=\"content_lista\">\n");
      out.write("                <h1>Lista de Categorias</h1>\n");
      out.write("                <div>\n");
      out.write("                    <table id=\"table3\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("                        \t<th>ID</th>\n");
      out.write("\t\t\t\t<th>DESCRIPCION</th>\n");
      out.write("\t\t\t\t<th>ACCION</th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");

                            ArrayList<CategoriaProducto> categorias = (ArrayList<CategoriaProducto>) request.getAttribute("categorias");
                            if(categorias == null){
                                System.out.println("vacio");
                            }else{
                            for (CategoriaProducto c : categorias) {
                        
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("                            <td>");
      out.print(c.getId_categoria());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(c.getDescripcion());
      out.write("</td>\n");
      out.write("                            <td style=\"width: 180px\">\n");
      out.write("                                <form action=\"/paronline/CategoriaProductoServlet\" method=\"post\">\n");
      out.write("                                    <input type=\"hidden\" name=\"vaccion\" value=\"Editar\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"vid\" value=\"");
      out.print(c.getId_categoria());
      out.write("\"/>\t\t\t\t\t\t\t\n");
      out.write("                                    <input type=\"submit\" id=\"deledit\"value=\"Edit\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"vaccion\" value=\"Eliminar\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"vid\" value=\"");
      out.print(c.getId_categoria());
      out.write("\"/>                                                        \n");
      out.write("                                    <input type=\"submit\" id=\"deledit\"value=\"Del\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");

                            }
                            }
                        
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\t\t<div style= \"margin-left:20%\">\n");
      out.write("                    <input type=\"submit\" id=\"btn_lista\" value=\"Agregar\" />\n");
      out.write("                    <input type=\"submit\" id=\"btn_lista\" value=\"Salir\" />\n");
      out.write("\t\t</div>\n");
      out.write("            </section>\n");
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
