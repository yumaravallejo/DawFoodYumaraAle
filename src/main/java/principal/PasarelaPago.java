
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.time.LocalDate;
import java.time.Month;
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
    
    public void rellenarTarjetas () {
        //Tarjetas de creditos creadas de manera al azar con su constructor vacío
        TarjetaCredito t0 = new TarjetaCredito("Javier");
        TarjetaCredito t1 = new TarjetaCredito("Felipe");
        TarjetaCredito t2 = new TarjetaCredito("Óscar");
        TarjetaCredito t3 = new TarjetaCredito("Rafael");
        TarjetaCredito t4 = new TarjetaCredito("Nuria");

        System.out.println(t0.toString());
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());

        //Añadimos a la lista las tarjetas de créditos
        pasarela.add(t0);
        pasarela.add(t1);
        pasarela.add(t2);
        pasarela.add(t3);
        pasarela.add(t4);
    }

    public  boolean pasarelaPagoB(Carrito c) {

        final int MIL = 1000;
        final int DIEZ = 10;
        final int CIEN = 100;

        

        //Variables para comprobar los bucles
        boolean digitosCorrectos = true;
        int contraTC = 0000;
        boolean datosCorrectos;
        int posicionTarje = 0;
        boolean repetir = true;
        int variable = 0;
        boolean pagoHecho;
        
        do {
            try {
                //Solicita la contraseña de la tarjeta de crédito
                String contraTexto = JOptionPane.showInputDialog(null,
                        "Introduce los últimos 4 dígitos de la contraseña");
                contraTC = Integer.parseInt(contraTexto);
                if (contraTexto.length() != 4) {
                    JOptionPane.showMessageDialog(null, "Introduce 4 dígitos");
                    digitosCorrectos = false;
                }
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Introduce valores correctos");
            }
        } while (!digitosCorrectos);

        //Comprueba los 4 digitos
        int digito1 = contraTC / MIL; //Primer Dígito
        int digito2 = (contraTC / CIEN) % DIEZ; //Segundo Dígito
        int digito3 = (contraTC / DIEZ) % DIEZ; //Tercer Dígito
        int digito4 = contraTC % DIEZ; //Cuarto Dígito

        //Bucle para entrar dentro de la lista donde se encuentran las tarjetas de credito
        //Entraremos para comparar los digitos de esas tarjetas 
        for (int i = 0; i < pasarela.size(); i++) {
            if (digito1 == pasarela.get(i).getDigito1()) {
                digitosCorrectos = true;
            } else {
                digitosCorrectos = false;
            }

            if (digito2 == pasarela.get(i).getDigito2() && digitosCorrectos == true) {
                digitosCorrectos = true;
            } else {
                digitosCorrectos = false;
            }

            if (digito3 == pasarela.get(i).getDigito3() && digitosCorrectos == true) {
                digitosCorrectos = true;
            } else {
                digitosCorrectos = false;
            }

            if (digito4 == pasarela.get(i).getDigito4() && digitosCorrectos == true) {
                digitosCorrectos = true;
            } else {
                digitosCorrectos = false;
            }

            if (digitosCorrectos) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado la tarjeta correctamente");
                //Esta variable guardará una vez acabado el número de la posición de la tarjeta para poder comparar con las otras cosas
                posicionTarje += i;
                break;
            }
        }

        
        if (!digitosCorrectos) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la tarjeta introducida en el sistema");
            
        } else { //Proceso para comprobar que el CVV y la tarjeta son correctos
            datosCorrectos = solicitarDatTarj(pasarela.get(posicionTarje));
            if (!datosCorrectos) {
            return false;
            } else {
                //Proceso de comprobación de pago si todo es correcto
                pagoHecho = comprobarDinero(c, pasarela.get(posicionTarje));
                if (pagoHecho = false) {
                    JOptionPane.showMessageDialog(null, "No tienes suficiente saldo");
                    return false;
                } else {
                    realizarPago(pasarela.get(posicionTarje), c);
                    JOptionPane.showMessageDialog(null, "Pago realizado satisfactoriamente");
                }
            }           
        } 
        return true;
    }

    //Este método solicitará los otros datos de la tarjeta (fecha de caducidad y cvv)
    public boolean solicitarDatTarj(TarjetaCredito t) {
        boolean valido = true;
        YearMonth fechaDada = YearMonth.of(2024, 1);
        int CVV = 111;
        int respuesta;
        String[] botones = {" Sí", "No"};

        //Bucle para que me de de manera correcta la fecha de caducidad
        do {
            try {
                //Solicitamos los valores de la fecha de caducidad de la tarjeta del usuario
                //Comprobamos que los valores son válidos
                int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de la fecha de caducidad de su tarjeta (1-12)"));
                if (mes <= 0 || mes > 12) {
                    JOptionPane.showMessageDialog(null, "Introduce un mes correcto (1-12)");
                    valido = false;
                }
                int año = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de la fecha de caducidad de su tarjeta"));
                if (año <= 2023) {
                    JOptionPane.showMessageDialog(null, "Su tarjeta está caducada");
                    return false;
                }
                fechaDada = YearMonth.of(año, mes);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Introduce valores correctos");
            }

        } while (!valido);

        //Comparamos la fecha dada por la fecha de la tarjeta que le pasamos al metodo
        if (!fechaDada.equals(t.getFechaCaduc())) {
            return false;
        }

        //Solicitamos el CVV (siempre que la fecha haya coincidido con la fecha de la tarjeta)
        do {
            try {
                String cvv = (JOptionPane.showInputDialog("Introduce tu CVV (XXX): "));
                if (cvv.length() != 3) {
                    JOptionPane.showMessageDialog(null, "Introduce tu CVV correctamente ");
                    valido = false;
                }
                //Lo convertimos a número
                CVV = Integer.parseInt(cvv);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Introduce valores correctos");
            }
            
        } while (!valido);
        
        //Digitos de la tarjeta
            int digito1 = (CVV / 100) % 10;
            int digito2 = (CVV/10) %10;
            int digito3 = CVV%10;
            
            if (digito1 != t.getCVV1()) {
                return false;
            } 
            
           if (digito2 != t.getCVV2()) {
                return false;
            } 
           
           if (digito3 != t.getCVV3()) {
                return false;
            } 
           
        return true;

    }

    //Este método comprobará que haya suficiente dinero
    public boolean comprobarDinero (Carrito c, TarjetaCredito t) {
        boolean valido = false;
        if (c.getPrecioTotal() > t.getSaldo()) {
            valido = false;
        }
        
        if (c.getPrecioTotal() <= t.getSaldo()) {
            valido = true;
        }
        return valido;
    }
    
    public void realizarPago (TarjetaCredito t, Carrito c) {
        double saldoNuevo =t.getSaldo() - c.getPrecioTotal();
        t.setSaldo(saldoNuevo);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasarela de Pago: ").append(pasarela);
        return sb.toString();
    }

}
