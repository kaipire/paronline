

package conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import modelo.TransaccionCab;


public class TransaccionCabConexion {
    public boolean insertar(TransaccionCab tc) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        int secuencia = 0;
        
        try {
            conn = BdConexion.getConnection();
            
            pstmt1 = conn.prepareStatement("select last_value from id_transaccion");
            rs = pstmt1.executeQuery();
            if(rs.next()){
                secuencia = rs.getInt(1);
            }
            pstmt = conn.prepareStatement("insert into transaccion_cab (id_cliente,monto_total,direccion,medio_pago,nro_tarjeta,fecha)"
                    + " values (?,?,?,?,?,?)");
            tc.setId_transaccion(secuencia+1);
            pstmt.setInt(1, tc.getCliente().getId_cliente());
            pstmt.setInt(2, tc.getMonto_total());
            pstmt.setString(3, tc.getDireccion());
            pstmt.setString(4, tc.getMedio_pago());
            pstmt.setString(5,tc.getNro_tarjeta());
            pstmt.setDate(6, tc.getFecha());
            
            pstmt.execute();
            
            
            System.out.println("este es el valor de la ultima secuencia");
            System.out.println(secuencia);
            
        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(TransaccionCabConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaccionCabConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean update(TransaccionCab tc) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            //arreglar desde aca
             pstmt = conn.prepareStatement("update transaccion_cab set monto_total = ?,direccion = ?,medio_pago = ?,nro_tarjeta=?,"
                    + " where id_transaccion=?");
            pstmt.setInt(5, tc.getId_transaccion());
            
            pstmt.setInt(1, tc.getMonto_total());
            pstmt.setString(2,tc.getDireccion());
            pstmt.setString(3,tc.getMedio_pago());
            pstmt.setString(4,tc.getNro_tarjeta());
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(TransaccionCabConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean delete(TransaccionCab tc) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("delete from transaccion_cab where id_transaccion = ?");
            pstmt.setInt(1, tc.getId_transaccion());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(TransaccionCabConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public TransaccionCab getTransaccionCabById(int id) throws Exception {
        TransaccionCab transaccion_cab = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ClienteConexion cc = new ClienteConexion();

       try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_transaccion, id_cliente, monto_total, direccion, medio_pago,"
                    + "nro_tarjeta,fecha from transaccion_cab where id_transaccion = ?");
                   
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery(); //un objto que puede soportar una tabla de resultado ejecutar consulta
            if (rs.next()) {
                transaccion_cab = new TransaccionCab();
                transaccion_cab.setId_transaccion(id);
                transaccion_cab.setCliente(cc.getClienteById(rs.getInt(1)));
                transaccion_cab.setMonto_total(rs.getInt(2));
                transaccion_cab.setDireccion(rs.getString(3));
                transaccion_cab.setMedio_pago(rs.getString(4));
                transaccion_cab.setNro_tarjeta(rs.getString(5));
                transaccion_cab.setFecha(rs.getDate(6));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransaccionCabConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return transaccion_cab;
    }
    
    public ArrayList<TransaccionCab> getAll() throws Exception {
        ArrayList<TransaccionCab> retValue = new ArrayList<TransaccionCab>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ClienteConexion cc = new ClienteConexion();

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_transaccion, id_cliente,monto_total,"
                    + "direccion,medio_pago,nro_tarjeta,fecha from transaccion_cab");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TransaccionCab tc = new TransaccionCab();
                tc.setId_transaccion(rs.getInt(1));
                tc.setCliente(cc.getClienteById(rs.getInt(2)));
                tc.setMonto_total(rs.getInt(3));
                tc.setDireccion(rs.getString(4));
                tc.setMedio_pago(rs.getString(5));
                tc.setNro_tarjeta(rs.getString(6));
                tc.setFecha(rs.getDate(7));
                retValue.add(tc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransaccionCabConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }    
}
  



