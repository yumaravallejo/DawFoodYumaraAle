/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import principal.Categorias;
import principal.IVA;
import principal.Subcategoria;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author yumara
 */
public class Productos {

    private final UUID id;
    private String Descripcion;
    private Categorias categoria;
    private Subcategoria subcategoria;
    private double precio;
    private IVA iva;
    private int stock;

    public Productos(String Descripcion, Categorias categoria, Subcategoria subcategoria, double precio, IVA iva, int stock) {
        this.id = UUID.randomUUID();
        this.Descripcion = Descripcion;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }

    public UUID getId() {
        return id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public principal.IVA getIva() {
        return iva;
    }

    public int getStock() {
        return stock;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIva(IVA iva) {
        this.iva = iva;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto ");
        sb.append(", descripcion=").append(Descripcion);
        sb.append(", categoria=").append(categoria);
        sb.append(", subcategoria=").append(subcategoria);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.Descripcion);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.subcategoria);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.iva);
        hash = 97 * hash + this.stock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productos other = (Productos) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.Descripcion, other.Descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        if (this.subcategoria != other.subcategoria) {
            return false;
        }
        return this.iva == other.iva;
    }

}
