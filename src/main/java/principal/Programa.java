/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import categorias.Categorias;
import categorias.IVA;
import categorias.Subcategoria;
import javax.swing.JOptionPane;
import objetos.Producto;

/**
 *
 * @author yumara
 */
public class Programa {

    public static void main(String[] args) {

        objetos.TPV tpv = new objetos.TPV("mesa");

        System.out.println(tpv);

        Producto p1 = new Producto("Holis", Categorias.COMIDA, Subcategoria.CARNE, 7, IVA.DIEZ, 1);
        System.out.println(p1);
    }
}
