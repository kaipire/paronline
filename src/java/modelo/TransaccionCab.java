
package modelo;

import java.sql.Date;



public class TransaccionCab {
    private int id_transaccion;
    private int monto_total;
    private String direccion;
    private String medio_pago;
    private String nro_tarjeta;
    private Cliente cliente;
    private Date fecha;

    public TransaccionCab() {
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "TransaccionCab{" + "id_transaccion=" + id_transaccion + ", monto_total=" + monto_total + ", direccion=" + direccion + ", medio_pago=" + medio_pago + ", nro_tarjeta=" + nro_tarjeta + ", cliente=" + cliente + '}';
    }
    
 }
   