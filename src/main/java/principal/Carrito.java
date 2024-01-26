/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;

/**
 *
 * @author yumara
 */
public class Carrito {
    
    private ArrayList<Productos> carrito;
    private double precioTotal;


    public Carrito() {
        this.carrito = new ArrayList<>();
        this.precioTotal = 0;
        
    }

    public ArrayList<Productos> getCarrito() {
        return carrito;
    }
    
    

    public void setCarrito(ArrayList<Productos> carrito) {
        this.carrito = carrito;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public Productos copiaPrd(Productos p){
        Productos copia = new Productos (p);
        return copia;
    }
    
    public void añadirCarrito(Productos p, int cantidad){
        Productos copia = copiaPrd(p);
        copia.setCantidadPedida(cantidad);
        for (int i = 0; i < cantidad; i++){
        carrito.add(copia);
        precioTotal += (copia.getPrecio()*cantidad);
        }
    }
    
    public void vaciarCarrito(){
        carrito.clear();
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carrito.size(); i++) {
            sb.append(carrito.get(i).getNombre());
            sb.append(" Precio: " + carrito.get(i).getPrecio() + "€");
            sb.append(" Cantidad: " + carrito.get(i).getCantidadPedida());
        }
        sb.append("\n Total (IVA aplicado): " + precioTotal + "€");
        return sb.toString();
    }
    
}
