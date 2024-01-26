/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package principal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author yumara
 */
public class Ticket {

    private UUID id;
    private double Precio;
    private LocalDateTime fechaOperacion;
    private ArrayList<Productos> productosPedidos;

    public Ticket(UUID id, double Precio, LocalDateTime fechaOperacion, ArrayList<Productos> productosPedidos) {
        this.id = UUID.randomUUID();
        this.Precio = Precio;
        this.fechaOperacion = fechaOperacion;
        this.productosPedidos = productosPedidos;
    }

    public UUID getId() {
        return id;
    }

    public double getPrecio() {
        return Precio;
    }

    public LocalDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public ArrayList<Productos> getProductosPedidos() {
        return productosPedidos;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setFechaOperacion(LocalDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public void setProductosPedidos(ArrayList<Productos> productosPedidos) {
        this.productosPedidos = productosPedidos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket{");
        sb.append("id=").append(id);
        sb.append(", Precio=").append(Precio);
        sb.append(", fechaOperacion=").append(fechaOperacion);
        sb.append(", productosPedidos=").append(productosPedidos);
        sb.append('}');
        return sb.toString();
    }
}
