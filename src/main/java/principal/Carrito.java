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
    private double precioTotalCon;

    public Carrito() {
        this.carrito = new ArrayList<>();
        for (int i = 0; i < carrito.size(); i++) {
            this.precioTotalCon += carrito.get(i).getPrecio();
        }
    }

    public ArrayList<Productos> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Productos> carrito) {
        this.carrito = carrito;
    }

    public double getPrecioTotalCon() {
        return precioTotalCon;
    }

    public void setPrecioTotalCon(double precioTotalCon) {
        this.precioTotalCon = precioTotalCon;
    }
    
    public void añadirCarrito(Productos p){
        carrito.add(p);
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito{");
        sb.append("carrito=").append(carrito);
        sb.append(", precioTotal=").append(precioTotalCon);
        sb.append('}');
        return sb.toString();
    }
    
}
