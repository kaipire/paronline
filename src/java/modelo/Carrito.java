/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


public class Carrito{
    private Producto producto;
    private int cantidad;
    

    public Carrito() {
    }

    public Carrito(Producto producto, int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Producto{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
    
}
