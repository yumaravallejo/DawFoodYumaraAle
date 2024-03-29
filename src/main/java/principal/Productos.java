
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
    private String nombre;
    private String descripcion;
    private Categorias categoria;
    private Subcategoria subcategoria;
    private double precio;
    private IVA iva;
    private int stock;
    private int cantidadPedida;


    public Productos(String nombre, String descripcion, Categorias categoria, Subcategoria subcategoria, double precio, IVA iva, int stock) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        if (this.subcategoria == Subcategoria.REFRESCO ||  this.subcategoria == Subcategoria.ALCOHOL){
        this.iva = IVA.VEINTIUNO;
        } else {
            this.iva = IVA.DIEZ;
        }
        this.precio = precio - (precio*this.iva.getPorcentaje());
        this.stock = stock;
        this.cantidadPedida = 0;
  
    }
    
    public Productos(Productos copia) {
        this.id = copia.id;
        this.cantidadPedida = copia.cantidadPedida;
        this.nombre = copia.nombre;
        this.categoria = copia.categoria;
        this.descripcion = copia.descripcion;
        this.iva = copia.iva;
        this.precio = copia.precio;
        this.stock = copia.stock;
        this.subcategoria = copia.subcategoria;
    }
    
    public UUID getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
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
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(", descripcion: ").append(descripcion);
        sb.append(", precio= ").append(precio);
        sb.append(", iva= ").append(iva);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
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
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
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

