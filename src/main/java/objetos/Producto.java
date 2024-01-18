/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import categorias.Categorias;
import categorias.IVA;
import categorias.Subcategoria;
import java.util.UUID;

/**
 *
 * @author yumara
 */
public class Producto {
    
    private final UUID id;
    private String Descripcion;
    private categorias.Categorias categoria;
    private categorias.Subcategoria subcategoria;
    private double precio;
    private categorias.IVA iva;
    private int stock;

    public Producto(String Descripcion, Categorias categoria, Subcategoria subcategoria, double precio, IVA iva, int stock) {
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

    public categorias.Categorias getCategoria() {
        return categoria;
    }

    public categorias.Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public categorias.IVA getIva() {
        return iva;
    }

    public int getStock() {
        return stock;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setCategoria(categorias.Categorias categoria) {
        this.categoria = categoria;
    }

    public void setSubcategoria(categorias.Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIva(categorias.IVA iva) {
        this.iva = iva;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("id=").append(id);
        sb.append(", Descripcion=").append(Descripcion);
        sb.append(", categoria=").append(categoria);
        sb.append(", subcategoria=").append(subcategoria);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
    
    
}
