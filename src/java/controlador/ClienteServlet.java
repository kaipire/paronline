/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import conexion.CategoriaProductoConexion;
import conexion.ClienteConexion;
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
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Producto;
import modelo.Usuario;


public class ClienteServlet extends HttpServlet {

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

        ClienteConexion cc = new ClienteConexion();
        HttpSession hs = request.getSession();
        Usuario u = (Usuario) hs.getAttribute("usuario");

        if (vaccion == null) {
            //modo grilla...se muestran todos los registros
            ArrayList<Cliente> clientes = cc.getAll();
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Eliminar".equals(vaccion)) {
            int idCli = Integer.valueOf(request.getParameter("vid"));
            Cliente c = new Cliente();
            c.setId_cliente(idCli);

            cc.delete(c);

            ArrayList<Cliente> clientes = cc.getAll();
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Registrar".equals(vaccion)) {
            //int id_cli = Integer.valueOf(request.getParameter("id_cli"));
            String nom = request.getParameter("nombre").trim();
            int ced = Integer.valueOf(request.getParameter("cedula"));
            String ape = request.getParameter("apellido").trim();
            String email = request.getParameter("email").trim();
            String cont = request.getParameter("cont").trim();
            Cliente c = new Cliente();
            Usuario u1 = new Usuario();
            
            c.setNombre(nom);
            c.setApellido(ape);
            c.setCedula(ced);
            c.setEmail(email);
            c.setContrasenha(cont);
            
            cc.insertar(c);
            
            ArrayList<Cliente> clientes = cc.getAll();
            request.setAttribute("clientes", clientes);
            if(c!=null){
                u1.setCedula(ced);
                u1.setContrasenha(cont);
                hs.setAttribute("usuario", u1);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                if (rd != null) {
                   rd.forward(request, response);
                }  
            }
            /*else{
               u.setCedula(ced);
               u.setContrasenha(cont);
               hs.setAttribute("usuario", u);
               RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
               if (rd != null) {
                  rd.forward(request, response); 
               }   
            }*/
        }

        if ("Editar".equals(vaccion)) {
            int idCli = Integer.valueOf(request.getParameter("id_cli"));
            ArrayList<Cliente> clientes = cc.getAll();
            for(Cliente c : clientes){
                if(idCli == c.getId_cliente()){
                    request.setAttribute("cliente", c);       
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/ClienteEditar.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
            int id_cli = Integer.valueOf(request.getParameter("id_cli"));
            int ced = Integer.valueOf(request.getParameter("cedula"));
            String nom = request.getParameter("nombre");
            String ape = request.getParameter("apellido");
            String email = request.getParameter("email");
            String cont = request.getParameter("cont");
            
            Cliente c = new Cliente();
            c.setId_cliente(id_cli);
            c.setNombre(nom);
            c.setApellido(ape);
            c.setCedula(ced);
            c.setEmail(email);
            c.setContrasenha(cont);
            
            cc.update(c);
            ArrayList<Cliente> clientes = cc.getAll();
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
