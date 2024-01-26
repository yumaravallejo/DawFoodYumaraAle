/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package principal;

/**
 *
 * @author yumara
 */
public enum Subcategoria {
       CARNE("Carnes"), MARISCO("Mariscos"), PASTA("Pastas"), REFRESCO("Refrescos"), 
       ALCOHOL("Bebidas Alcohólicas"), ZUMO("Zumos"), POSTRE("Postre");

       private String nombre;

    private Subcategoria(String nombre) {
        this.nombre = nombre;
    }

    public static Subcategoria getCARNE() {
        return CARNE;
    }

    public static Subcategoria getMARISCO() {
        return MARISCO;
    }

    public static Subcategoria getPASTA() {
        return PASTA;
    }

    public static Subcategoria getREFRESCO() {
        return REFRESCO;
    }

    public static Subcategoria getALCOHOL() {
        return ALCOHOL;
    }

    public static Subcategoria getZUMO() {
        return ZUMO;
    }

    public String getNombre() {
        return nombre;
    }
    
    
       
}
