/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDate;

/**
 *
 * @author yumara
 */
public class TarjetaCredito {
    
    private LocalDate fechaCaduc;
    private int CVV;
    private double saldo;
    private int digitos;

    public TarjetaCredito(LocalDate fechaCaduc, int CVV, double saldo, int digitos) {
        this.fechaCaduc = fechaCaduc;
        this.CVV = CVV;
        this.saldo = saldo;
        this.digitos = digitos;
        
        
   
    }

    public LocalDate getFechaCaduc() {
        return fechaCaduc;
    }

    public void setFechaCaduc(LocalDate fechaCaduc) {
        this.fechaCaduc = fechaCaduc;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getDigitos() {
        return digitos;
    }

    public void setDigitos(int digitos) {
        this.digitos = digitos;
    }
}
