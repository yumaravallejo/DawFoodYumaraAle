/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class PasarelaPago {

    private ArrayList<TarjetaCredito> pasarela;

    //Constructor predeterminado
    public PasarelaPago() {
        this.pasarela = new ArrayList<>();
    }

    public void pasarelaPagoB() {

        final int MIL = 1000;
        final int DIEZ = 10;
        final int CIEN = 100;

        //Tarjetas de creditos creadas de manera al azar con su constructor vacío
        TarjetaCredito t0 = new TarjetaCredito();
        TarjetaCredito t1 = new TarjetaCredito();
        TarjetaCredito t2 = new TarjetaCredito();
        TarjetaCredito t3 = new TarjetaCredito();
        TarjetaCredito t4 = new TarjetaCredito();

        //Añadimos a la lista las tarjetas de créditos
        pasarela.add(t0);
        pasarela.add(t1);
        pasarela.add(t2);
        pasarela.add(t3);
        pasarela.add(t4);

        //Variables para comprobar los bucles
        boolean valido = true;
        boolean correcto = false;
        int contraTC = 0000;

        do {
            try {
                //Solicita la contraseña de la tarjeta de crédito
                String contraTexto = JOptionPane.showInputDialog(null,
                        "Introduce los últimos 4 dígitos de la contraseña");
                contraTC = Integer.parseInt(contraTexto);
                if (contraTexto.length() != 4) {
                    System.out.println("Introduce 4 dígitos");
                    valido = false;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Introduce valores correctos");
            }
        } while (!valido);

        //Comprueba los 4 digitos
        int digito1 = contraTC / MIL; //Primer Dígito
        int digito2 = (contraTC / CIEN) % DIEZ; //Segundo Dígito
        int digito3 = (contraTC / DIEZ) % DIEZ; //Tercer Dígito
        int digito4 = contraTC % DIEZ; //Cuarto Dígito

        //Bucle para entrar dentro de la lista donde se encuentran las tarjetas de credito
        //Entraremos para comparar los digitos de esas tarjetas 
       for (int i = 0; i < pasarela.size(); i++) {
        if (digito1 == pasarela.get(i).getDigito1()) {
            valido = true;
        } else {valido = false;}
        
        if (digito2 == pasarela.get(i).getDigito2() &&  valido==true) {
            valido = true;
        } else {valido = false;}
        
        if (digito3 == pasarela.get(i).getDigito3() &&  valido==true) {
            valido = true;
        } else {valido = false;}
        
        if (digito4 ==pasarela.get(i).getDigito4() &&  valido==true) {
            valido = true;
        } else {valido = false;}
        
       }
    
 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasarela de Pago: ").append(pasarela);
        return sb.toString();
    }

}
