

package modelo;


public class TransaccionDet {
    private int id_detalle;
    private TransaccionCab trans_cab;
    private Producto producto;
    private int importe_bruto;
    private int cantidad;
    
    public TransaccionDet() {
        
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public TransaccionCab getTrans_cab() {
        return trans_cab;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public void setTrans_cab(TransaccionCab trans_cab) {
        this.trans_cab = trans_cab;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getImporte_bruto() {
        return importe_bruto;
    }

    public void setImporte_bruto(int importe_bruto) {
        this.importe_bruto = importe_bruto;
    }

    @Override
    public String toString() {
        return "TransaccionDet{" + "id_detalle=" + id_detalle + ", trans_cab=" + trans_cab + ", producto=" + producto + ", importe_bruto=" + importe_bruto + ", cantidad=" + cantidad + '}';
    }

    
    
}    

    