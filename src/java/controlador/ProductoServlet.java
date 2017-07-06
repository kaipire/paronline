

package controlador;

import conexion.CategoriaProductoConexion;
import conexion.ProductoConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CategoriaProducto;
import modelo.Producto;


public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String vaccion = request.getParameter("vaccion");
        request.setAttribute("vaccion", vaccion);

        ProductoConexion pc = new ProductoConexion();
        CategoriaProductoConexion cp = new CategoriaProductoConexion(); 

        if (vaccion == null) {
            //modo grilla...se muestran todos los registros
            ArrayList<Producto> productos = pc.getAll();
            request.setAttribute("productos", productos);
            RequestDispatcher rd = request.getRequestDispatcher("/Producto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Eliminar".equals(vaccion)) {
            int idProd = Integer.valueOf(request.getParameter("id_pro"));
            Producto p = new Producto();
            p.setId_producto(idProd);

            pc.delete(p);

            ArrayList<Producto> productos = pc.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/Producto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Registrar".equals(vaccion)) {
            int id_cat = Integer.valueOf(request.getParameter("id_cat"));
            int id_pro = Integer.valueOf(request.getParameter("id_pro"));
            String desc = request.getParameter("descripcion").trim();
            int pre = Integer.valueOf(request.getParameter("precio"));
            Producto p = new Producto();
            p.setId_producto(id_pro);
            p.setCategoria(cp.getCategoriaById(id_cat));
            p.setDescripcion(desc);
            p.setPrecio(pre);

            pc.insertar(p);

            ArrayList<Producto> productos = pc.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/Producto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Editar".equals(vaccion)) {
            int idProd = Integer.valueOf(request.getParameter("id_pro"));
            Producto p = pc.getProductoById(idProd);

            request.setAttribute("producto", p);

            RequestDispatcher rd = request.getRequestDispatcher("/ProductoEditar.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
            int id_cat = Integer.valueOf(request.getParameter("id_cat"));
            int id_pro = Integer.valueOf(request.getParameter("id_pro"));
            String desc = request.getParameter("descripcion").trim();
            int pre = Integer.valueOf(request.getParameter("precio"));
            
            Producto p = new Producto();
            p.setId_producto(id_pro);
            p.setDescripcion(desc);
            p.setCategoria(cp.getCategoriaById(id_cat));
            p.setPrecio(pre);
            
            pc.update(p);

            ArrayList<Producto> productos = pc.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/Producto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

 