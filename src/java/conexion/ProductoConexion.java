

package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CategoriaProducto;
import modelo.Producto;


public class ProductoConexion {
    public boolean insertar(Producto p) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("insert into producto (id_producto, descripcion, id_categoria, precio) values (?,?,?,?)");
            pstmt.setInt(1, p.getId_producto());
            pstmt.setString(2, p.getDescripcion());
            pstmt.setInt(3, p.getCategoria().getId_categoria());
            pstmt.setInt(4, p.getPrecio());
            
            pstmt.execute();
        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
    
    public boolean update(Producto p) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("update producto set precio = ?, descripcion = ?, id_categoria=?  where id_producto = ? ");
            pstmt.setInt(1, p.getPrecio());
            pstmt.setString(2, p.getDescripcion());
            pstmt.setInt(3, p.getCategoria().getId_categoria());
            pstmt.setInt(4, p.getId_producto());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }
        return retValue;
    }
    
    public boolean delete(Producto p) throws Exception {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("delete from producto where id_producto = ?");
            pstmt.setInt(1, p.getId_producto());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(ProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
    
    public Producto getProductoById(int id) throws Exception {
        
        Producto producto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CategoriaProductoConexion cp = new CategoriaProductoConexion();

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_producto, descripcion, id_categoria, precio"
                    + " from producto where id_producto = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery(); //un objto que puede soportar una tabla de resultado ejecutar consulta
            if (rs.next()) {
                producto = new Producto();
                producto.setId_producto(id);
                producto.setDescripcion(rs.getString(2));
                producto.setCategoria(cp.getCategoriaById(rs.getInt(3)));
                producto.setPrecio(rs.getInt(4));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return producto;
    }
    
    
        public ArrayList<Producto> getAll() throws Exception {
        ArrayList<Producto> retValue = new ArrayList<Producto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CategoriaProductoConexion cp = new CategoriaProductoConexion();

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_producto,descripcion, id_categoria, precio "
                    + " from producto");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId_producto(rs.getInt(1));
                p.setDescripcion(rs.getString(2));
                p.setCategoria(cp.getCategoriaById(rs.getInt(3)));
                p.setPrecio(rs.getInt(4));
                
                retValue.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
    public ArrayList<Producto> getAllByCat(int categoria) throws Exception {
        ArrayList<Producto> retValue = new ArrayList<Producto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = BdConexion.getConnection();
            pstmt = conn.prepareStatement("select id_producto, descripcion from producto where id_categoria = ?");
            pstmt.setInt(1, categoria);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId_producto(rs.getInt(1));
                p.setDescripcion(rs.getString(2));
                retValue.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaProductoConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BdConexion.closeConnection(conn);
        }

        return retValue;
    }
            

}
