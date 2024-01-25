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
    private int[] CVV = new int[3];
    private double saldo;
    private int[] digitos = new int[16]; //numero de la tarjeta
    private final int TAM_TARJ = 16;
    String saldoCompl;

    public TarjetaCredito() {
        Random rd = new Random();
        int mes = rd.nextInt(1, 13);
        int año = rd.nextInt(2020, 2035);
        this.fechaCaduc = YearMonth.of(año, mes);
        //Creamos el CVV

        for (int i = 0; i < CVV.length; i++) {
            CVV[i] = rd.nextInt(0, 10);
        }
        for (int i = 0; i < digitos.length; i++) {
            digitos[i] = rd.nextInt(0, 10);
        }

        this.CVV = CVV;
        this.saldo = rd.nextDouble(0, 501);
        this.digitos = digitos;
        saldoCompl = """ 
                     %.2f """.formatted(saldo);
    }

    public YearMonth getFechaCaduc() {
        return fechaCaduc;
    }

    public void setFechaCaduc(YearMonth fechaCaduc) {
        this.fechaCaduc = fechaCaduc;
    }

    public void getCVV() {
        for (int i = 0; i < CVV.length; i++) {
            System.out.println(CVV[i]);
        }
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

    public int getDigito1() {
        return digitos[12];
    }

    public int getDigito2() {
        return digitos[13];
    }

    public int getDigito3() {
        return digitos[14];
    }

    public int getDigito4() {
        return digitos[15];
    }

    public void setDigitos(int[] digitos) {
        this.digitos = digitos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarjetaCredito{");
        sb.append("fechaCaduc=").append(fechaCaduc);
        sb.append(", CVV=");
        for (int i = 0; i < CVV.length; i++) {
            sb.append(CVV[i]);
        }
        sb.append(", saldo=").append(saldoCompl);
        sb.append(" digitos=");
        for (int i = 0; i < digitos.length; i++) {
            sb.append(digitos[i]);
        }

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
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.fechaCaduc);
        hash = 41 * hash + Arrays.hashCode(this.CVV);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 41 * hash + Arrays.hashCode(this.digitos);
        return hash;
    }

}
