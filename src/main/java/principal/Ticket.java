/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package principal;

import java.time.LocalDateTime;
import java.time.Month;
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
    private Carrito productos;

    public Ticket(Carrito c) {
        this.id = UUID.randomUUID();
        this.productos = c;
        this.fechaOperacion = LocalDateTime.now();
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

    public Carrito getProductosPedidos() {
        return productos;
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

    public void setProductosPedidos(Carrito productosPedidos) {
        this.productos = productosPedidos;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket --> ");
        sb.append("id: ").append(id);
        sb.append(", fechaOperacion: ").append(fechaOperacion);
        sb.append(", productosPedidos: ").append(productos);

        return sb.toString();
    }
}