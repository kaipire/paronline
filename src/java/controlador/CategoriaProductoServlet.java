
package controlador;

import conexion.CategoriaProductoConexion;
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


public class CategoriaProductoServlet extends HttpServlet {

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

        CategoriaProductoConexion cm = new CategoriaProductoConexion();

        if (vaccion == null) {
            //modo grilla...se muestran todos los registros
            ArrayList<CategoriaProducto> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/CategoriaProducto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Eliminar".equals(vaccion)) {
            int idCat = Integer.valueOf(request.getParameter("vid"));
            CategoriaProducto c = new CategoriaProducto();
            c.setId_categoria(idCat);

            cm.delete(c);

            ArrayList<CategoriaProducto> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/CategoriaProducto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarNuevo".equals(vaccion)) {
            //int idCat = Integer.valueOf(request.getParameter("id"));
            String desc = request.getParameter("descripcion");
            CategoriaProducto c = new CategoriaProducto();
            //c.setId_categoria(idCat);
            c.setDescripcion(desc);

            cm.insertar(c);

            ArrayList<CategoriaProducto> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/CategoriaProducto.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Editar".equals(vaccion)) {
            int idCat = Integer.valueOf(request.getParameter("vid"));
            CategoriaProducto c = cm.getCategoriaById(idCat);

            request.setAttribute("categoria", c);

            RequestDispatcher rd = request.getRequestDispatcher("/CategoriaProductoEditar.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
            int idCat = Integer.valueOf(request.getParameter("vid"));
            String desc = request.getParameter("descripcion");
            CategoriaProducto c = new CategoriaProducto();
            c.setId_categoria(idCat);
            c.setDescripcion(desc);

            cm.update(c);

            ArrayList<CategoriaProducto> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/CategoriaProducto.jsp");
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
            Logger.getLogger(CategoriaProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CategoriaProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
