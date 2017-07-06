/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CategoriaProducto;


public class CategoriaProductoConexion {
  
    public boolean insertar(CategoriaProducto c) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("insert into categoria_producto (descripcion) values (?)");
            //pstmt.setInt(1, c.getId_categoria());
            pstmt.setString(1, c.getDescripcion());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean update(CategoriaProducto c) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            //arreglar desde aca
            pstmt = conn.prepareStatement("update categoria_producto set descripcion = ? where id_categoria = ?");
            pstmt.setInt(2, c.getId_categoria());
            pstmt.setString(1, c.getDescripcion());
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public boolean delete(CategoriaProducto c) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("delete from categoria_producto where id_categoria = ?");
            pstmt.setInt(1, c.getId_categoria());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }

    public CategoriaProducto getCategoriaById(int id) throws Exception {
        CategoriaProducto retValue = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select descripcion from categoria_producto where id_categoria = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue = new CategoriaProducto();
                retValue.setId_categoria(id);
                retValue.setDescripcion(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
    
    public ArrayList<CategoriaProducto> getAll() throws Exception {
        ArrayList<CategoriaProducto> retValue = new ArrayList<CategoriaProducto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_categoria, descripcion from categoria_producto");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CategoriaProducto c = new CategoriaProducto();
                c.setId_categoria(rs.getInt(1));
                c.setDescripcion(rs.getString(2));
                retValue.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
    
}
  

