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
public class Catalogo {

    private ArrayList<Productos> listaProductos;

    //Constructor Predeterminado
    public Catalogo() {
        this.listaProductos = new ArrayList<>();
    }

    //agrega al final de la lista el nuevo elemento.
    public void añadir(Productos p) {
        listaProductos.add(p);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catálogo \n").append(listaProductos);
        return sb.toString();
    }
}
