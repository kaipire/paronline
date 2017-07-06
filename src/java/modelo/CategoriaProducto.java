

package modelo;


public class CategoriaProducto {
  private int id_categoria;
  private String descripcion;

    public CategoriaProducto(int id_categoria, String descripcion) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
    }

    public CategoriaProducto() {
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" + "id_categoria=" + id_categoria + ", descripcion=" + descripcion + '}';
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
}
