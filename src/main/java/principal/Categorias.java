/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package principal;

/**
 *
 * @author yumara
 */
public enum Categorias {
        COMIDA("Comida"), BEBIDA("Bebida"), POSTRE("Postre");

        private String nombre;

    private Categorias(String nombre) {
        this.nombre = nombre;
    }

    public static Categorias getCOMIDA() {
        return COMIDA;
    }

    public static Categorias getBEBIDA() {
        return BEBIDA;
    }

    public static Categorias getPOSTRE() {
        return POSTRE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
     
  
}
