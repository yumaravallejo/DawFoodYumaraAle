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
    
    //Métodos de ordenación
    public void ordenarPorDigitos () {
        Collections.sort(pasarela,(c1,c2) -> Integer.compare(c1.getDigitos(), c2.getDigitos()));
    }
    
    public void ordenarPorCVV () {
        Collections.sort(pasarela,(c1,c2) -> Integer.compare(c1.getCVV(), c2.getCVV()));
    }
    
    public void ordenarPorFecha () {
        Collections.sort(pasarela, (c1,c2) -> (c1.getFechaCaduc().compareTo(c2.getFechaCaduc())));
    }
    
    //BinarySearch
    public int buscarElementoDig (TarjetaCredito t, int numeroBuscado){
        t.setDigitos(numeroBuscado);
        ordenarPorDigitos();
        return Collections.binarySearch(pasarela, t, (c1,c2) -> 
                Integer.compare(c1.getDigitos(), c2.getDigitos()));
    }
    
    public int buscarElementoCVV (TarjetaCredito t, int numeroBuscado){
        t.setCVV(numeroBuscado);
        ordenarPorCVV();
        return Collections.binarySearch(pasarela, t, (c1,c2) -> 
                Integer.compare(c1.getCVV(), c2.getCVV()));
    }
    
    public int buscarElementoFech (TarjetaCredito t, YearMonth fechaCad){
        t.setFechaCaduc(fechaCad);
        ordenarPorFecha();
        return Collections.binarySearch(pasarela, t, (c1,c2) -> 
                (c1.getFechaCaduc().compareTo(c2.getFechaCaduc())));
    }
    
    public void pasarelaPagoB() {
        
        final int MIL = 1000;
        final int DIEZ = 10;
        final int CIEN = 100;
        
        TarjetaCredito t0 = new TarjetaCredito();
        TarjetaCredito t1 = new TarjetaCredito();
        TarjetaCredito t2 = new TarjetaCredito();
        TarjetaCredito t3 = new TarjetaCredito();
        TarjetaCredito t4 = new TarjetaCredito();
        
        pasarela.add(t0);
        pasarela.add(t1);
        pasarela.add(t2);
        pasarela.add(t3);
        pasarela.add(t4);
                
        boolean correcto = true;
        int contraTC = 0000;
        
        do {
            try {
                //Solicita la contraseña de la tarjeta de crédito
                String contraTexto = JOptionPane.showInputDialog(null,
                        "Introduce los últimos 4 dígitos de la contraseña");
                contraTC = Integer.parseInt(contraTexto);
                if (contraTexto.length() != 4 ) {
                    System.out.println("Introduce 4 dígitos");
                    correcto = false;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Introduce valores correctos");
            }
        } while (!correcto);

        //Comprueba la contraseña
        //Hacemos uso del BS para buscar la tarjeta en la lista, ya está previamente ordenada 
        
        int digito1 = contraTC / MIL; //Primer Dígito
        int digito2 = (contraTC / CIEN) % DIEZ; //Segundo Dígito
        int digito3 = (contraTC / DIEZ) % DIEZ; //Tercer Dígito
        int digito4 = contraTC % DIEZ; //Cuarto Dígito
        
        for (int i = 0; i < pasarela.size(); i++) {
           
        }
        
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasarela de Pago: ").append(pasarela);
        return sb.toString();
    }
    
    
}
