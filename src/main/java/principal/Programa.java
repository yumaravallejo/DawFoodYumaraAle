/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import javax.swing.JOptionPane;

/**
 *
 * @author yumara
 */
public class Programa {

    public static void main(String[] args) {

        principal.TPV tpv = new principal.TPV("mesa");

        System.out.println(tpv);

        Productos p1 = new Productos("Holis", Categorias.COMIDA, Subcategoria.CARNE, 7, IVA.DIEZ, 1);
        System.out.println(p1);
        
        Catalogo c1 = new Catalogo();
        
        c1.añadir(p1);
        
        System.out.println(c1.toString());
    }
}
