
package modelo;

import conexion.ClienteConexion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int cedula;
    private String contrasenha;

    public Usuario() {
    }

    public Usuario(int cedula, String contrasenha) {
        this.cedula = cedula;
        this.contrasenha = contrasenha;
    }

    public int getCedula() {
        return cedula;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    
    @Override
    public String toString() {
        ClienteConexion cc = new ClienteConexion();
        ArrayList<Cliente> cliente = null;
        try {
            cliente = cc.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cedula == 12345){
            return "NO LOGUEADO";
        }
        else{
            for(Cliente c : cliente){
                if(c.getCedula() == cedula){
                    return c.getNombre().toUpperCase()  + c.getApellido().toUpperCase();
                }
            }
        }
        return null;
    }
    
}
