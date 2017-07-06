

package modelo;

import java.util.Collections;

public class Producto implements Comparable<Producto> {
    private int id_producto;
    private String descripcion;
    private CategoriaProducto categoria;
    private int precio;

    public Producto() {
    }

    public Producto(int id_producto, String descripcion, CategoriaProducto categoria, int precio) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio=" + precio + '}';
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int compareTo(Producto p) {
        return descripcion.compareTo(p.getDescripcion());
    }

    
}    
    
    

    