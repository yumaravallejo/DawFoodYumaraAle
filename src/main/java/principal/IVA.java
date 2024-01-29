/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package principal;

/**
 *
 * @author yumara
 */
public enum IVA {
    VEINTIUNO(0.21), DIEZ(0.10);
    
    private double porcentaje;

    private IVA(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}