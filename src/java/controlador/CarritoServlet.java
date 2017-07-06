

package controlador;

import conexion.ProductoConexion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrito;
import modelo.Producto;
import modelo.TransaccionCab;
import modelo.TransaccionDet;
import modelo.Usuario;


public class CarritoServlet extends HttpServlet {

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
       int id_pro=0;
       int cant=0;
       String agregar=null;
       String confirmar=null;
       String quitar = null;
       int monto_total = 0;
       TransaccionDet td = new TransaccionDet();
       TransaccionCab tc = new TransaccionCab();
       if(request.getParameter("vid") != null){
           id_pro = Integer.valueOf(request.getParameter("vid"));    
       }
       if(request.getParameter("cantidad") != null){
           cant = Integer.valueOf(request.getParameter("cantidad"));
        }
       if(request.getParameter("vaccion")!= null ){
          agregar = request.getParameter("vaccion");
          request.setAttribute("vaccion", agregar);
       }
       if(request.getParameter("confirmar") != null){
           confirmar = request.getParameter("confirmar");
           request.setAttribute("confirmar", confirmar);
       }
       if(request.getParameter("quitar") != null){
           quitar = request.getParameter("quitar");
           request.setAttribute("quitar", quitar);
       }
       ArrayList<Carrito> carrito = new ArrayList<Carrito>();
       
       
       HttpSession hs = request.getSession();
       Usuario u = (Usuario)hs.getAttribute("usuario");
       
       
       Producto pr = new Producto();
       ProductoConexion pc = new ProductoConexion();
       
       pr = pc.getProductoById(id_pro);
       Carrito c = new Carrito();
       
        if ("agregar_carrito".equals(agregar)) {
            if (hs.getAttribute("carrito") == null && u == null) {
                c.setCantidad(cant);
                c.setProducto(pr);
                carrito.add(c);
                hs.setAttribute("carrito", carrito);
                
                u = new Usuario(12345,"establecido");
                System.out.println(u);
                hs.setAttribute("usuario", u);
                System.out.println("if de usuario null");
                System.out.println("antes del carrito");
                System.out.println(c);
                System.out.println("despues del carrito");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                if (rd != null) {
                    rd.forward(request, response);
                }
            } else if (hs.getAttribute("carrito") == null && u != null) {
                c.setCantidad(cant);
                c.setProducto(pr);
                carrito.add(c);
                hs.setAttribute("carrito", carrito);

                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                if (rd != null) {
                    rd.forward(request, response);
                }
            } else if (hs.getAttribute("carrito") != null && u != null) {
                carrito = (ArrayList<Carrito>) hs.getAttribute("carrito");

                c.setCantidad(cant);
                c.setProducto(pr);
                carrito.add(c);
                hs.setAttribute("carrito", carrito);

                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                if (rd != null) {
                    rd.forward(request, response);
                }

            } else if (hs.getAttribute("carrito") != null && u == null) {

                carrito = (ArrayList<Carrito>) hs.getAttribute("carrito");
                c.setCantidad(cant);
                c.setProducto(pr);
                carrito.add(c);
                hs.setAttribute("carrito", carrito);
                u.setCedula(12345);
                u.setContrasenha("establecido");
                hs.setAttribute("usuario", u);
                System.out.println("if de usuario null carrito no null");
                System.out.println(c);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                if (rd != null) {
                    rd.forward(request, response);
                }
            }
        }else if("quitar".equals(quitar)){
            carrito = (ArrayList<Carrito>) hs.getAttribute("carrito");
            System.out.println("antes de quitar un producto");
            System.out.println(carrito);
            for(Carrito c1 : carrito){
                if(c1.getProducto().getId_producto() == id_pro){
                    carrito.remove(c1);
                    break;
                    
                }
            }
            System.out.println("despues de quitar un producto");
            System.out.println(carrito);
            hs.setAttribute("carrito", carrito);
            hs.setAttribute("usuario",u );
            RequestDispatcher rd = request.getRequestDispatcher("/Carrito.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        } else if ("conf_carrito".equals(confirmar)) {
            carrito = (ArrayList<Carrito>) hs.getAttribute("carrito");
            
            //u = (Usuario) hs.getAttribute("usuario");
           // carrito = duplicado(carrito);
            System.out.println("carrito antes de confirmar");
            System.out.println(carrito);
            System.out.println("carrito despues de confirmar");
            request.setAttribute("carrito", carrito);
            System.out.println(u);
            request.setAttribute("usuario", u);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Carrito.jsp");
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
            Logger.getLogger(CarritoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CarritoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
