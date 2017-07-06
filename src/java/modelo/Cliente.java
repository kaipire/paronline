

package modelo;

import java.util.logging.Logger;

/**
 *
 * @author baltios
 */
public class Cliente {
    private int id_cliente;
    private String nombre; 
    private String apellido;
    private String email;
    private TransaccionCab compra;
    private int cedula;
    private String contrasenha;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String email, TransaccionCab compra, int cedula, String contrasenha) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.compra = compra;
        this.cedula = cedula;
        this.contrasenha = contrasenha;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", compra=" + compra + ", cedula=" + cedula + ", contrasenha=" + contrasenha + '}';
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public TransaccionCab getCompra() {
        return compra;
    }

    public int getCedula() {
        return cedula;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompra(TransaccionCab compra) {
        this.compra = compra;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    
}
    