

package controlador;

import conexion.ClienteConexion;
import conexion.TransaccionCabConexion;
import conexion.TransaccionDetConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrito;
import modelo.Cliente;
import modelo.TransaccionCab;
import modelo.TransaccionDet;
import modelo.Usuario;

public class TransaccionServlet extends HttpServlet {

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
        
        String confirmar = request.getParameter("confirmar");
        request.setAttribute("confirmar", confirmar);
        String cancelar = request.getParameter("cancelar");
        request.setAttribute("cancelar", cancelar);
        
        String direccion =  null;
        String efectivo = null;
        String tarjeta = null;
        String nro_tarjeta = null;
        String medio_pago = null;
        int monto_total=0;
       
        Date now = new Date(System.currentTimeMillis());

            
        
        TransaccionCabConexion tcc = new TransaccionCabConexion();
        TransaccionCab tc = new TransaccionCab();
       
        TransaccionDetConexion tdc = new TransaccionDetConexion();
        TransaccionDet td = new TransaccionDet();
        HttpSession hs = request.getSession();
        
        Usuario u = (Usuario) hs.getAttribute("usuario");
        
        
        ClienteConexion cc = new ClienteConexion();
        ArrayList<Carrito> carrito = (ArrayList<Carrito>) hs.getAttribute("carrito");
        ArrayList<Cliente> cliente = cc.getAll();
        System.out.println("aqui empiezan las pruebas");
        hs.setAttribute("direccion", direccion);
        System.out.println(hs.getAttribute("direccion"));
        
       if(hs.getAttribute("monto_total") != null){
            
            monto_total = Integer.valueOf(hs.getAttribute("monto_total").toString());
            System.out.println("aca esta el valor de monto_total");
            System.out.println(monto_total);
        }
        if(request.getParameter("direccion") != null){
            direccion = request.getParameter("direccion").trim();
            
        }
        
        /*if(request.getParameter("tarjeta") != null){
            medio_pago = request.getParameter("tarjeta");
            System.out.println("esto es tarjeta");
            System.out.println(medio_pago);
        }*/
        if(request.getParameter("pago") != null){
            System.out.println("Esto es lo que queremos saber");
            System.out.println(request.getParameter("pago"));
            if("tarjeta".equals(request.getParameter("pago"))){
                medio_pago = "tarjeta";
                System.out.println(medio_pago);
            }
            else if("efectivo".equals(request.getParameter("pago").trim())){
                medio_pago = "efectivo";
                System.out.println(medio_pago);
            }
        }
        if(request.getParameter("nro_tarjeta") != null){
            nro_tarjeta = request.getParameter("nro_tarjeta");
            System.out.println("esto es nro_tarjeta");
            System.out.println(nro_tarjeta);
        }
        
        if("confirmar".equals(confirmar)){
            
            if(u.getCedula() == 12345){
                 
               RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                if (rd != null) {
                  rd.forward(request, response);
                } 
            }
            else if(u != null && u.getCedula()!= 12345){
                for(Cliente cl : cliente) {
                    if(cl.getCedula() == u.getCedula()){
                       tc.setCliente(cl);     
                    }   
                }  
                
                tc.setMonto_total(monto_total);
                tc.setDireccion(direccion);
                tc.setMedio_pago(medio_pago);
                tc.setNro_tarjeta(nro_tarjeta);
                
                tc.setFecha(now);
                tcc.insertar(tc);
                
               
                for(Carrito c1 : carrito){
                   
                    td.setCantidad(c1.getCantidad());
                    td.setProducto(c1.getProducto());
                    td.setImporte_bruto(c1.getCantidad() * c1.getProducto().getPrecio());
                    
                    td.setTrans_cab(tc);
                    tdc.insertar(td);
                }
                hs.setAttribute("carrito",null);
            }
            //hs.setAttribute("carrito",null);
           RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
           if (rd != null) {
               rd.forward(request, response);
            }  
        }
        else if("cancelar".equals(cancelar)){
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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
            Logger.getLogger(TransaccionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaccionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
