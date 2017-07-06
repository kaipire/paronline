


package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BdConexion {
    
    public static Connection getConnection() throws SQLException, NamingException, Exception {
        Connection conn;
        InitialContext cxt = new InitialContext();
        if (cxt == null) {
            throw new Exception("Uh oh -- no context!");
        }

        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");
        conn = ds.getConnection();
        
        if (ds == null) {
            throw new Exception("Data source not found!");
        }
        return conn;
        
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BdConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 /*public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BdConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CarritoPar", "postgres", "misael77");
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BdConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/   
}
