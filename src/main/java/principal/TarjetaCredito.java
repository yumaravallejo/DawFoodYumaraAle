/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author yumara
 */
public class TarjetaCredito {
    
    private LocalDate fechaCaduc;
    private int CVV;
    private double saldo;
    private int digitos; //numero de la tarjeta

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
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarjetaCredito{");
        sb.append("fechaCaduc=").append(fechaCaduc);
        sb.append(", CVV=").append(CVV);
        sb.append(", saldo=").append(saldo);
        sb.append(", digitos=").append(digitos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.fechaCaduc);
        hash = 29 * hash + this.CVV;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 29 * hash + this.digitos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TarjetaCredito other = (TarjetaCredito) obj;
        if (this.CVV != other.CVV) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (this.digitos != other.digitos) {
            return false;
        }
        return Objects.equals(this.fechaCaduc, other.fechaCaduc);
    }
}
