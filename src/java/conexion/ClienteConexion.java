

package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;


public class ClienteConexion {
    public boolean insertar(Cliente c) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;
        

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("insert into cliente (nombre,cedula,apellido,email,contrasenha)"
                    + " values (?,?,?,?,?)");
            //pstmt.setInt(1, c.getId_cliente());
            pstmt.setString(1, c.getNombre());
            pstmt.setInt(2, c.getCedula());
            pstmt.setString(3, c.getApellido());
            pstmt.setString(4, c.getEmail());
            pstmt.setString(5, c.getContrasenha());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean update(Cliente c) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            //arreglar desde aca
            pstmt = conn.prepareStatement("update cliente set nombre = ?,cedula = ?,apellido = ?,email=?,"
                    + "contrasenha=? where id_cliente = ?");
            pstmt.setInt(6, c.getId_cliente());
            pstmt.setString(1, c.getNombre());
            pstmt.setInt(2, c.getCedula());
            pstmt.setString(3, c.getApellido());
            pstmt.setString(4, c.getEmail());
            pstmt.setString(5, c.getContrasenha());
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ClienteConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean delete(Cliente c) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("delete from cliente where id_cliente = ?");
            pstmt.setInt(1, c.getId_cliente());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ClienteConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
    public int isusuario(int cedula,String cont) throws Exception {
        int retValue = 3;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select cedula, contrasenha from cliente where cedula = ? and contrasenha = ?");
            pstmt.setInt(1, cedula);
            pstmt.setString(2, cont);
            pstmt.execute();
            rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getInt(1) == 4144757 && cont.equals(rs.getString(2).trim())){
                    
                    retValue = 1;
                }
                else{
                    retValue = 2;
                }
            }    

        } catch (SQLException ex) {
            retValue=3;
            Logger.getLogger(ClienteConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public Cliente getClienteById(int id) throws Exception {
        Cliente cliente = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select nombre,cedula,apellido,email,contrasenha from cliente where id_cliente = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(id);
                cliente.setNombre(rs.getString(1));
                cliente.setCedula(rs.getInt(2));
                cliente.setApellido(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setContrasenha(rs.getString(5));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return cliente;
    }
    
    public ArrayList<Cliente> getAll() throws Exception {
        ArrayList<Cliente> retValue = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_cliente, nombre, cedula, apellido,"
                    + "email,contrasenha from cliente");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setCedula(rs.getInt(3));
                c.setApellido(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setContrasenha(rs.getString(6));
           
                retValue.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }    
}
  
