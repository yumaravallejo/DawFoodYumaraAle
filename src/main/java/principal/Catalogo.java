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

    public void listaProductos() {

        Productos p1 = new Productos("Hamburguesa", "Hamburguesa de "
                + "ternera con tomate, lechuga y queso ", Categorias.COMIDA,
                Subcategoria.CARNE, 6, IVA.DIEZ, 32);
        Productos p2 = new Productos("Entrecot", " Carne de ternera"
                + " en su punto ", Categorias.COMIDA,
                Subcategoria.CARNE, 12, IVA.DIEZ, 18);
        Productos p3 = new Productos("Pasta carbonara", "Espaguetis carbonara "
                + " con champiñones ", Categorias.COMIDA,
                Subcategoria.PASTA, 7, IVA.DIEZ, 24);
        Productos p4 = new Productos("Gambas al pil-pil", " Gambas con "
                + " ajo y cayena ", Categorias.COMIDA,
                Subcategoria.MARISCO, 12, IVA.DIEZ, 40);
        Productos p5 = new Productos("Coca-Cola", " Refresco con gas ",
                Categorias.BEBIDA, Subcategoria.REFRESCO, 2,
                IVA.VEINTIUNO, 60);
        Productos p6 = new Productos("Fanta de naranja", " Refresco con gas ",
                Categorias.BEBIDA, Subcategoria.REFRESCO, 2,
                IVA.VEINTIUNO, 62);
        Productos p7 = new Productos("Fanta de limón", " Refresco con gas ",
                Categorias.BEBIDA, Subcategoria.REFRESCO, 2,
                IVA.VEINTIUNO, 61);
        Productos p8 = new Productos("Zumo de manzana", " Bebida sin gas ",
                Categorias.BEBIDA, Subcategoria.ZUMO, 1.5,
                IVA.DIEZ, 56);
        Productos p9 = new Productos("Zumo de naranja", " Bebida sin gas ",
                Categorias.BEBIDA, Subcategoria.ZUMO, 1.5,
                IVA.DIEZ, 44);
        Productos p10 = new Productos("Zumo de piña", " Bebida sin gas ",
                Categorias.BEBIDA, Subcategoria.ZUMO, 1.5,
                IVA.DIEZ, 57);
        Productos p11 = new Productos("Cerveza", " Cerveza Cruzcampo ",
                Categorias.BEBIDA, Subcategoria.ALCOHOL, 2.3,
                IVA.VEINTIUNO, 57);
        Productos p12 = new Productos("Vino tinto", " Vino tinto ",
                Categorias.BEBIDA, Subcategoria.ALCOHOL, 32,
                IVA.VEINTIUNO, 20);
        Productos p13 = new Productos("Vino blanco", " Vino blanco ",
                Categorias.BEBIDA, Subcategoria.ALCOHOL, 27,
                IVA.VEINTIUNO, 22);
        Productos p14 = new Productos("Solomillo al roquefort", " Solomillo cocinado en su punto"
                + " junto a salsa roquefort", Categorias.COMIDA,
                Subcategoria.CARNE, 12, IVA.DIEZ, 24);
        Productos p15 = new Productos("Hamburguesa infantil", " Pequeña hamburguesa de ternera"
                + " de tamaño ideal para infantes", Categorias.COMIDA,
                Subcategoria.CARNE, 5, IVA.DIEZ, 38);
        Productos p16 = new Productos("Nuggets", " 13 nuggets ",
                Categorias.COMIDA, Subcategoria.CARNE, 6,
                IVA.DIEZ, 24);

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
