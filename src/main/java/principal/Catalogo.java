/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

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

    public void listaProductos() {

        Productos p1 = new Productos("Hamburguesa", "Hamburguesa de"
                + "ternera con tomate, lechuga y queso ", Categorias.COMIDA,
                Subcategoria.CARNE, 8, IVA.DIEZ, 32);
        Productos p2 = new Productos("Entrecot", "Carne de ternera"
                + " en su punto ", Categorias.COMIDA,
                Subcategoria.CARNE, 19, IVA.DIEZ, 18);
        Productos p3 = new Productos("Pasta carbonara", "Espaguetis carbonara"
                + " con champiñones ", Categorias.COMIDA,
                Subcategoria.PASTA, 9.50, IVA.DIEZ, 24);
        Productos p4 = new Productos("Gambas al pil-pil", "Gambas con"
                + " ajo y cayena ", Categorias.COMIDA,
                Subcategoria.MARISCO, 12.50, IVA.DIEZ, 40);
        Productos p5 = new Productos("Coca-Cola", "Refresco con gas",
                Categorias.BEBIDA, Subcategoria.REFRESCO, 2,
                IVA.VEINTIUNO, 60);
        Productos p6 = new Productos("Fanta de naranja", "Refresco con gas",
                Categorias.BEBIDA, Subcategoria.REFRESCO, 2,
                IVA.VEINTIUNO, 62);
        Productos p7 = new Productos("Fanta de limón", "Refresco con gas",
                Categorias.BEBIDA, Subcategoria.REFRESCO, 2,
                IVA.VEINTIUNO, 61);
        Productos p8 = new Productos("Zumo de manzana", "Bebida sin gas",
                Categorias.BEBIDA, Subcategoria.ZUMO, 1.5,
                IVA.DIEZ, 56);
        Productos p9 = new Productos("Zumo de naranja", "Bebida sin gas",
                Categorias.BEBIDA, Subcategoria.ZUMO, 1.5,
                IVA.DIEZ, 44);
        Productos p10 = new Productos("Zumo de piña", "Bebida sin gas",
                Categorias.BEBIDA, Subcategoria.ZUMO, 1.5,
                IVA.DIEZ, 57);
        Productos p11 = new Productos("Cerveza", "Cerveza Cruzcampo",
                Categorias.BEBIDA, Subcategoria.ALCOHOL, 2.3,
                IVA.VEINTIUNO, 57);
        Productos p12 = new Productos("Vino tinto", "Vino tinto",
                Categorias.BEBIDA, Subcategoria.ALCOHOL, 32,
                IVA.VEINTIUNO, 20);
        Productos p13 = new Productos("Vino blanco", " Vino blanco",
                Categorias.BEBIDA, Subcategoria.ALCOHOL, 27,
                IVA.VEINTIUNO, 22);
        Productos p14 = new Productos("Solomillo al roquefort", "Solomillo cocinado en su punto"
                + " junto a salsa roquefort", Categorias.COMIDA,
                Subcategoria.CARNE, 12, IVA.DIEZ, 24);
        Productos p15 = new Productos("Nuggets", "13 nuggets",
                Categorias.COMIDA, Subcategoria.CARNE, 6,
                IVA.DIEZ, 24);
        Productos p16 = new Productos("Lasaña", "Lasaña",
                Categorias.COMIDA, Subcategoria.PASTA, 10, IVA.DIEZ, 40);
        Productos p17 = new Productos("Pasta al pesto", "Macarrones al pesto",
                Categorias.COMIDA, Subcategoria.PASTA, 9.50, IVA.DIEZ, 24);
        Productos p18 = new Productos("Ostras", "Ostras servidas con limón (se cobra la unidad)", Categorias.COMIDA,
                Subcategoria.MARISCO, 5.50, IVA.DIEZ, 30);
        Productos p19 = new Productos("Almejas finas", "Almejas finas en salsa de ajito", Categorias.COMIDA,
                Subcategoria.MARISCO, 28, IVA.DIEZ, 70);
        Productos p20 = new Productos("Crepes", "Crepes con nata y chocolate", Categorias.POSTRE,
                Subcategoria.POSTRE, 3, IVA.DIEZ, 40);
        Productos p21 = new Productos("Tarta de queso", "Tarta de queso con sirope de frutos rojos", Categorias.POSTRE,
                Subcategoria.POSTRE, 4.50, IVA.DIEZ, 20);
        Productos p22 = new Productos("Flan", "Flan de vainilla", Categorias.POSTRE,
                Subcategoria.POSTRE, 2.50, IVA.DIEZ, 35);

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);
        listaProductos.add(p7);
        listaProductos.add(p8);
        listaProductos.add(p9);
        listaProductos.add(p10);
        listaProductos.add(p11);
        listaProductos.add(p12);
        listaProductos.add(p13);
        listaProductos.add(p14);
        listaProductos.add(p15);
        listaProductos.add(p16);
        listaProductos.add(p17);
        listaProductos.add(p18);
        listaProductos.add(p19);
        listaProductos.add(p20);
        listaProductos.add(p21);
        listaProductos.add(p22);
    }

    //agrega al final de la lista el nuevo elemento.
    public void añadir(Productos p) {
        listaProductos.add(p);
    }
    
    public int tamaño() {
        return listaProductos.size();
    }
    
 


    public Productos obtener(int i) {

        System.out.println(listaProductos);
        Productos p = listaProductos.get(i);
        return p;
    }

    public void mostrarLista() {
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.print(i+". ");
            System.out.println(listaProductos.get(i));
        }
    }
            
    public void eliminarProducto(int i){
        listaProductos.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaProductos.size(); i++) {
            sb.append(listaProductos.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void eliminarProducto(Productos i) {
        listaProductos.remove(i);

    }
}

