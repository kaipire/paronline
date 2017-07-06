

package controlador;

import conexion.ClienteConexion;
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
import javax.servlet.http.HttpSession;
import modelo.Carrito;
import modelo.Usuario;


public class LoginServlet extends HttpServlet {

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
        String vaccion = request.getParameter("vaccion").trim();
            request.setAttribute("vaccion", vaccion);
        
            
        //int cedula=0;
        //String cont=null;
        HttpSession hs = request.getSession();
        Usuario u = new Usuario();
        ArrayList<Carrito> carrito = (ArrayList<Carrito>) hs.getAttribute("carrito");
        //u = (Usuario) hs.getAttribute("usuario"); //aca edite
        ClienteConexion cc = new ClienteConexion();
        System.out.println(hs.getAttribute("usuario"));
        if(hs.getAttribute("usuario") == null){
            if ("login".equals(vaccion)) {
                int cedula = Integer.valueOf(request.getParameter("cedula"));
                String cont = request.getParameter("contrasenha").trim();
                int usuario = cc.isusuario(cedula, cont);
                String mensaje = "usuario incorrecto";
                if (usuario == 1) {
                    u.setCedula(cedula);
                    u.setContrasenha(cont);
                    hs.setAttribute("usuario", u);
                    RequestDispatcher rd = request.getRequestDispatcher("/indexAdmin.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }
                } else if (usuario == 2) {
                    
                    u.setCedula(cedula);
                    u.setContrasenha(cont);
                    hs.setAttribute("usuario", u);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }
                } else {
                    
                    request.setAttribute("error", mensaje);
                    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }
                }
               
            }
            
        }
        else if(hs.getAttribute("usuario") != null){
            if ("login".equals(vaccion)) {
                Usuario u1 = (Usuario) hs.getAttribute("usuario");
                int cedula = Integer.valueOf(request.getParameter("cedula"));
                String cont = request.getParameter("contrasenha").trim();
                int aux = cc.isusuario(cedula, cont);
                if(u1.getCedula() == 12345 && aux == 1){
                    u1.setCedula(cedula);
                    u1.setContrasenha(cont);
                    hs.setAttribute("usuario", u1);
                    RequestDispatcher rd = request.getRequestDispatcher("/indexAdmin.jsp");
                    if (rd != null) {
                       rd.forward(request, response);
                   }
                }
                else if(u1.getCedula()==12345 && aux == 2){
                    u1.setCedula(cedula);
                    u1.setContrasenha(cont);
                    hs.setAttribute("usuario", u1);
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    if (rd != null) {
                       rd.forward(request, response);
                   }
                }
                else{
                    request.setAttribute("error", "Usuario no puede loguearse");
                    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                   }
                }
            }
            
        }
        else{
            request.setAttribute("error", "Usuario no puede loguearse");
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
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
        
        String cerrar = request.getParameter("cerrar");
        if("cerrar".equals(cerrar)){
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            
            response.sendRedirect("/paronline/index.jsp");
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
