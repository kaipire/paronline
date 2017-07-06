
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.TransaccionDet;


public class TransaccionDetConexion {
    public boolean insertar(TransaccionDet td) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("insert into transaccion_det (id_transaccion,id_producto,importe_bruto,cantidad)"
                    + " values (?,?,?,?)");
            //pstmt.setInt(1, td.getId_detalle());
            pstmt.setInt(1, td.getTrans_cab().getId_transaccion());
            pstmt.setInt(2, td.getProducto().getId_producto());
            pstmt.setInt(3, td.getImporte_bruto());
            pstmt.setInt(4, td.getCantidad());
             
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean update(TransaccionDet td) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            
            pstmt = conn.prepareStatement("update transaccion_det set cantidad=?  where id_detalle=?");
            pstmt.setInt(2, td.getId_detalle());
            
            pstmt.setInt(1, td.getCantidad());
            
            
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean delete(TransaccionDet td) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("delete from transaccion_det where id_detalle = ?");
            pstmt.setInt(1, td.getId_detalle());
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public TransaccionDet getTransaccionDetById(int id) throws Exception {
        TransaccionDet transaccion_det = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TransaccionCabConexion tc = new TransaccionCabConexion();
        ProductoConexion pc = new ProductoConexion();

       try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_detalle, id_transaccion, id_producto,importe_bruto, cantidad"
                    + " from transaccion_det where id_detalle=?");
                   
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery(); //un objto que puede soportar una tabla de resultado ejecutar consulta
            if (rs.next()) {
                transaccion_det = new TransaccionDet();
                transaccion_det.setId_detalle(id);
                transaccion_det.setTrans_cab(tc.getTransaccionCabById(rs.getInt(1)));
                transaccion_det.setProducto(pc.getProductoById(rs.getInt(2)));
                transaccion_det.setImporte_bruto(rs.getInt(3));
                transaccion_det.setCantidad(rs.getInt(4));
                        
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return transaccion_det;
    }
    
    public ArrayList<TransaccionDet> getAll() throws Exception {
        ArrayList<TransaccionDet> retValue = new ArrayList<TransaccionDet>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TransaccionCabConexion tcc = new TransaccionCabConexion();
        ProductoConexion pc = new ProductoConexion();
        

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_detalle, id_transaccion, id_producto,importe_bruto,cantidad"
                    + " from transaccion_det");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TransaccionDet td = new TransaccionDet();
                td.setId_detalle(rs.getInt(1));
                td.setTrans_cab(tcc.getTransaccionCabById(rs.getInt(2)));
                td.setProducto(pc.getProductoById(rs.getInt(3)));
                td.setImporte_bruto(rs.getInt(4));
                td.setCantidad(rs.getInt(5));
                
               
                retValue.add(td);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    } 
    public ResultSet historial(int cedula)throws Exception{
       
        ResultSet rs1= null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("SELECT tc.id_transaccion,td.id_producto,p.descripcion,p.precio,td.cantidad,importe_bruto,tc.monto_total,tc.fecha from cliente c\n" +
                     "inner join transaccion_cab tc \n" +
                     "on tc.id_cliente = c.id_cliente\n" +
                     "inner join transaccion_det td\n" +
                     "on td.id_transaccion = tc.id_transaccion\n" +
                     "inner join producto p\n" +
                     "on p.id_producto = td.id_producto\n" +
                     "where cedula = ? order by c.nombre;");
            
            pstmt.setInt(1, cedula);
            rs = pstmt.executeQuery();
            rs1 = rs;
          

        } catch (SQLException ex) {
            Logger.getLogger(TransaccionDetConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConexionBD.closeConnection(conn);
        }

        return rs1;
    }  
    
}
  




