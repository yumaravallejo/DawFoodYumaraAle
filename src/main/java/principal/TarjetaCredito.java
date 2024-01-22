/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author yumara
 */
public class TarjetaCredito {
    
    private YearMonth fechaCaduc;
    private int CVV;
    private double saldo;
    private int[] digitos; //numero de la tarjeta
    private final int TAM_TARJ = 16;

    public TarjetaCredito() {
        Random rd = new Random();
        int mes = rd.nextInt(1,13);
        int año = rd.nextInt(2020, 2035);
        this.fechaCaduc = YearMonth.of(año, mes);
        //Creamos el CVV
        int numeroCVV1 = rd.nextInt(0,10);
        int numeroCVV2 = rd.nextInt(0,10);
        int numeroCVV3 = rd.nextInt(0,10);
        this.CVV = numeroCVV1 + numeroCVV2 + numeroCVV3;
        this.saldo = rd.nextDouble(0, 501);
        for (int i=0; i<TAM_TARJ; i++){
            this.digitos[i] = rd.nextInt(0,10);
        }
    }

    public YearMonth getFechaCaduc() {
        return fechaCaduc;
    }

    public void setFechaCaduc(YearMonth fechaCaduc) {
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

    public int[] getDigitos() {
        return digitos;
    }

    public void setDigitos(int[] digitos) {
        this.digitos = digitos;
    }
    
    public boolean compararNumeros (int digito1, int digito2, int digito3, int digito4) {
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.fechaCaduc);
        hash = 59 * hash + this.CVV;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 59 * hash + Arrays.hashCode(this.digitos);
        return hash;
    }
    
    
}
