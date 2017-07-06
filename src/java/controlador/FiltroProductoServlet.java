

package controlador;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import conexion.ProductoConexion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;


public class FiltroProductoServlet extends HttpServlet {

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
        int cat = 0;
        ProductoConexion pc = new ProductoConexion();
        String cate_filtro = null;
        String cate_descripcion = null;
        //Falta poner los filtros  
        cate_descripcion = request.getParameter("descripcion");
        cate_filtro = request.getParameter("categorias_productos");
        if(cate_descripcion != null){
            ArrayList<Producto> productos = filtro_desc(cate_descripcion);
            Collections.sort(productos);
            request.setAttribute("array_producto",productos);  
            
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");//alamr al servlet deproducto
            if (rd != null) {
                rd.forward(request, response);
            }
        }
        
        
        else if (request.getParameter("cat") != null) {
            cat = Integer.valueOf(request.getParameter("cat"));

            if (cat == 1) {
                ArrayList<Producto> productos = pc.getAllByCat(cat);
                Collections.sort(productos);
                request.setAttribute("array_producto", productos);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");//alamr al servlet deproducto
                if (rd != null) {
                    rd.forward(request, response);
                }
            } else if (cat == 2) {
                
                ArrayList<Producto> productos = pc.getAllByCat(cat);
                Collections.sort(productos);
                request.setAttribute("array_producto", productos);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");//alamr al servlet deproducto
                if (rd != null) {
                    rd.forward(request, response);
                }
            } else {
                ArrayList<Producto> productos = pc.getAllByCat(cat);
                Collections.sort(productos);
                request.setAttribute("array_producto", productos);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");//alamr al servlet deproducto
                if (rd != null) {
                    rd.forward(request, response);
                }
            }
       }
        
    } 
    
    
    private ArrayList<Producto> filtro_desc(String desc) throws Exception {
        ArrayList<Producto> descripciones = new ArrayList<Producto>();
        String cat="categorias_productos"; 
        ProductoConexion pc = new ProductoConexion();
        
        
        for (Producto array_pro : pc.getAll()) {
            if(cat.equals("cat1")){
                int index = array_pro.getDescripcion().toLowerCase().indexOf(desc.trim());
                if (index > -1) {
                    descripciones.add(array_pro);
                }  
            }
            else if(cat == "cat2"){
                int index = array_pro.getDescripcion().toLowerCase().indexOf(desc.trim());
                if (index > -1) {
                    descripciones.add(array_pro);
                }   
            }
            else if(cat == "cat3"){
                int index = array_pro.getDescripcion().toLowerCase().indexOf(desc.trim());
                if (index > -1) {
                    descripciones.add(array_pro);
                }  
            }
            else{
                int index = array_pro.getDescripcion().toLowerCase().indexOf(desc.trim());
                if (index > -1) {
                    descripciones.add(array_pro);
                }    
            }
        }
        return descripciones;
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
            Logger.getLogger(FiltroProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FiltroProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
